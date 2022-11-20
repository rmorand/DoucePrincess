import random

"""
    Programme simulant un jeu de BlackJack avec des lancés de dés. L'objectif du jeu est d'arriver au plus proche de
    21 sans dépasser 21. Pour se faire l'utilisateur peut lancer un nombre de dés de son choix. Le programme simule un
    lancer de dés (en générant aléatoirement des valeurs entre 1 et 6) et obtiens une somme. L'utilisateur peut décider
    de continuer de lancer des dés supplémentaires ou de s'arrêter (entrer 0 lorsque l'on demande le nombre de dés).
    L'ordinateur joue également en parallèle avec sa propre somme et son score est affiché également. Le jeu se termine lorsque le
    joueur ET l'ordinateur ont terminé de jouer.
    Indications:
        - Si le joueur entre 0 comme nombre de dés à lancer, cela signifie qu'il arrête de lancer plus de dés et sa partie se termine
        - Voici le détail sur la stratégie de jeu de l'ordinateur:
            - Si la somme de l'ordinateur est inférieure à 6, il demande 3 dés
            - Si la somme de l'ordinateur est supérieure ou égale à 6 et inférieure à 12, il demande 2 dés
            - Si la somme de l'ordinateur est supérieure ou égale à 12 et inférieure à 18, il demande 1 dés
            - Si la somme de l'ordinateur est supérieure ou égale à 18, il s'arrête de jouer
"""


# Fonctions

def jeu():
    player_dice_number = 99
    computer_dice_number = 99
    score_player: int = 0
    score_ordinateur: int = 0
    objectif: int = 21
    while (score_player and score_ordinateur) < objectif and (player_dice_number and computer_dice_number) != 0:
        if player_dice_number != 0:
            result: list
            result = jeu_joueur(score_player, objectif)
            score_player = result[0]
            player_dice_number = result[1]
        if computer_dice_number != 0:
            result: list
            result = jeu_ordinateur(score_ordinateur, objectif)
            score_ordinateur = result[0]
            computer_dice_number = result[1]
    affichage_resultat(score_player, score_ordinateur, objectif)


def computer_select_dice_number(_computer_score: int) -> int:
    if _computer_score >= 18:
        return 0
    if _computer_score >= 12:
        return 1
    if _computer_score >= 6:
        return 2
    if _computer_score < 6:
        return 3


def jeu_joueur(_score_joueur: int, _objectif: int) -> list:
    new_score_joueur: int = _score_joueur
    user_dice_number: str = input("Combien de dés souhaitez-vous lancer ?")
    for dice in range(0, int(user_dice_number)):
        dice_result: int = random.randint(1, 6)
        new_score_joueur += dice_result
    print("Vous avez un score de", new_score_joueur, end="\n\n")
    result: list = [new_score_joueur, int(user_dice_number)]
    return result


def jeu_ordinateur(_score_ordinateur: int, _objectif: int) -> list:
    new_score_ordinateur: int = _score_ordinateur
    computer_dice_number: int = computer_select_dice_number(_score_ordinateur)
    print("L'ordinateur choisi {cdn} dé{s}".format(cdn=computer_dice_number, s="s" if computer_dice_number > 1 else ""))
    for dice in range(0, computer_dice_number):
        dice_result: int = random.randint(1, 6)
        new_score_ordinateur += dice_result
    print("L'ordinateur à un score de", new_score_ordinateur, end="\n\n")
    result: list = [new_score_ordinateur, computer_dice_number]
    return result


def affichage_resultat(_score_player: int, _score_computer: int, _objectif: int):
    if _score_player > _objectif and _score_computer > _objectif:
        print("Vous avez perdu, car vous avez dépassé 21 ({sp})".format(sp=_score_player))
        print("Rassurez-vous l'ordinateur n'a pas fait mieux ({sc})".format(sc=_score_computer))
    if _score_player > _objectif >= _score_computer:
        print("Vous avez perdu ({sp}) contre l'ordinateur ({sc})".format(sp=_score_player, sc=_score_computer))
    if _objectif >= _score_player > _score_computer:
        print("Vous avez gagnez ({sp}) contre l'ordinateur ({sc})".format(sp=_score_player, sc=_score_computer))
    if _score_player == _score_computer:
        print("Egalité! Pas de gagnant ! ({sp})".format(sp=_score_player))


# Programme principal
### Déclaration et Initialisation des variables


### Séquence d'opérations
if __name__ == "__main__":
    jeu()
