import random

saved_value: int = 0
dice1: int = 0
dice2: int = 0
dice3: int = 0


def launch_dice(dice_value):
    return random.randint(1, 6) if (dice_value != saved_value or saved_value == 0) else saved_value


def print_dice():
    print('|', dice1, '| ', '|', dice2, '| ', '|', dice3, '|')


def calc_score():
    if dice1 == dice2 == dice3:
        if dice1 == 1:
            return 100
        if dice1 == 6:
            return 60
        return dice1
    return 0


total_score: int = 0
while total_score < 200:
    user_entry: str = "0"
    dice_to_launch: int = 3
    round_current: int = 1
    saved_value = 0

    while user_entry != "":
        user_entry = input("Appuyer sur \"Enter\" pour lancer les dés")
    for round_current in range(1, 4):
        dice1 = launch_dice(dice1)
        dice2 = launch_dice(dice2)
        dice3 = launch_dice(dice3)
        print_dice()
        while round_current < 3:
            user_entry = input("Voulez-vous garder une valeur ? (1-6)")
            if user_entry == "":
                saved_value = 0
                break
            if user_entry.isdigit() and int(user_entry) in range(1, 7):
                saved_value = int(user_entry)
                break
    total_score += calc_score()
    print("Votre score est : {t} pts".format(t=total_score))
