def affichage_mot_cache(MOT: str, chosen_letters: list, try_left: int):
    for letter in MOT:
        if letter in chosen_letters or letter in {" ", "-"}:
            print(letter, end="")
        else:
            print("_", end="")
    print("             ({try_left:} erreur{plural:} restante{plural:})"
          .format(try_left=try_left, plural="s" if try_left > 1 else ""))


def tirage_lettre(chosen_letters: list):
    previous_len: int = len(chosen_letters)
    while len(chosen_letters) == previous_len:
        chosen_letter = input("Veuillez entrer une lettre que vous n'avez pas choisie avant : ")
        if len(chosen_letter) == 1 and str.isalpha(chosen_letter) and chosen_letter not in chosen_letters:
            chosen_letters.append(chosen_letter)
    return chosen_letters


def verification_mot(MOT: str, chosen_letters: list):
    for letter in MOT:
        if letter not in chosen_letters:
            return False
    return True


def diminuer_erreur(try_left: int):
    return try_left - 1


def select_word():
    return "mot a trouver"

def main():
    MOT: str = select_word()
    chosen_letters: list = []
    try_left: int = 10
    while try_left > 0 and not verification_mot(MOT, chosen_letters):
        affichage_mot_cache(MOT, chosen_letters, try_left)
        chosen_letters = tirage_lettre(chosen_letters)
        if chosen_letters[-1] not in MOT:
            try_left = diminuer_erreur(try_left)
    if verification_mot(MOT, chosen_letters):
        print("Bravo vous avez trouvé le mot!", MOT)
    else:
        print("Vous avez perdu! Le mot était :", MOT)

if __name__ == '__main__':
    main()
