total: int


def is_integer(number_to_test):
    try:
        float(number_to_test)
    except ValueError:
        return False
    else:
        return float(number_to_test).is_integer()


user_str: str = ""
while user_str is not is_integer(user_str) or int(user_str) <= 10:
    user_str = input("Veuillez entrer un nombre plus grand que 10 : ")
    if not is_integer(user_str):
        print("Error : not an integer")
    elif int(user_str) <= 10:
        print("le nombre " + user_str + " n'est pas plus grand que 10")
nbr: str = user_str
while int(nbr) > 10:
    nbrs: list = []
    for x in nbr:
        new_x: int = int(x) * int(x)
        nbrs.append(new_x)
        print(x + "^2=" + str(new_x))
    nbr = str(sum(nbrs))
    # Hooouuuu que c'est moche ya forcement moyen de faire mieux
    print("Nouveau nombre : ", end="")
    for n in nbrs:
        print(n, end="+" if not n == nbrs[-1] else "")
    print("=" + nbr)
if int(nbr) == 1:
    print("Le nombre " + user_str + " est un nombre porte bonheur !")
else:
    print("Le nombre " + user_str + " n'est pas un nombre porte bonheur !")
