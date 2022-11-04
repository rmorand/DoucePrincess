import random

while 1:
    user_entry: str = "0"
    dice_to_launch: int = 3
    round_current: int = 1
    while user_entry != "":
        user_entry = input("Appuyer sur \"Enter\" pour lancer les dés")
    number_of_dice: int = 0
    for number_of_dice in range(1, 4):
        print('|', random.randint(1, 6), '|', end=" " if number_of_dice < dice_to_launch else "\n")
