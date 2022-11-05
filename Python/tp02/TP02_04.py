tank_capacity: int = 199158
consumption: float = 1340.78
max_passenger: int = 580
fuel_per_passenger_increase_percent: float = 0.1724
tank_actual: int = tank_capacity
passenger: int = 0
total_travel: int = 0
user_input: str = ""


def is_integer(n):
    try:
        float(n)
    except ValueError:
        return False
    else:
        return float(n).is_integer()


def calc_consumption(distance, passenger):
    return distance * (consumption + consumption * fuel_per_passenger_increase_percent / 100 * passenger) / 100


while 1:
    user_input = input("Entrez la distance de votre destination ou 0 pour faire le plein : ")
    if not is_integer(user_input):
        if user_input == "quit":
            break
        print("Error : La valeur entrée n'est pas un integer")
        continue
    distance = int(user_input)
    if distance == 0:
        tank_actual = tank_capacity
        print("Le réservoir est rempli totalement.")
        continue
    user_input = ""

    while not is_integer(user_input):
        user_input: str = input("Combien de passagers ? ")
        if not is_integer(user_input):
            print("Error : La valeur entrée n'est pas un integer")
            continue
        passenger = int(user_input)
        if passenger > max_passenger:
            if user_input == "quit":
                break
            print("Vol impossible ! Vous avez dépassé le nombre maximal de passagers !")
            continue
    if user_input == "quit":
        break
    user_input = ""

    if tank_actual < calc_consumption(distance, passenger):
        print("Vol impossible ! Vous n'avez pas assez de carburant! (Le voyage ne sera pas pris en compte)")
        continue
    tank_actual -= calc_consumption(distance, passenger)
    total_travel += distance
    print("Il vous reste encore {:.2f} litres de carburant.".format(tank_actual))
print("Vous aurez parcouru {:.1f}km.".format(total_travel))
