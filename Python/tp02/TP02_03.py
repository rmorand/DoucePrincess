# Ceci est mon commentaire:
hundred: int = 0
ten: int = 0
unit: int = 0

for hundred in range(0, 10):
    if hundred % 3 == 0:
        for ten in range(0, 10):
            if ten % 3 == 0:
                for unit in range(0, 10):
                    if (hundred + ten + unit == 12) and (hundred * 100 + ten * 10 + unit) % 78 == 0:
                        print("Combination : {h} {t} {u}".format(h=hundred, t=ten, u=unit))
                        break
            else:
                continue
    else:
        continue
