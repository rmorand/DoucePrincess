import random

saved_value: int = 0
dices: list = list((0, 0, 0))


def launch_dice(dice_value):
    return random.randint(1, 6) if (dice_value != saved_value or saved_value == 0) else saved_value


def print_dice():
    print('|', dices[0], '| ', '|', dices[1], '| ', '|', dices[2], '|')


def calc_score():
    if dices[0] == dices[1] == dices[2]:
        if 1 in dices:
            return 100
        if 6 in dices:
            return 60
        return dices[0]
    return 0


total_score: int = 0
while total_score < 200:
    user_entry: str = "0"
    saved_value = 0

    while user_entry != "":
        user_entry = input("Appuyer sur \"Enter\" pour lancer les dés")
    for current_round in range(1, 4):
        dices = [launch_dice(dice) for dice in dices]
        print_dice()
        if dices[0] == dices[1] == dices[2]:
            break
        while current_round < 3:
            user_entry = input("Voulez-vous garder une valeur ? (1-6)")
            if user_entry == "":
                saved_value = 0
                break
            if user_entry.isdigit() and int(user_entry) in range(1, 7):
                saved_value = int(user_entry)
                break
    total_score += calc_score()
    print("Votre score est : ", total_score, "pts")
