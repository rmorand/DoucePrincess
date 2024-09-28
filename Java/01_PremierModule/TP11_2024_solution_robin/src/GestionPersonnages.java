import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionPersonnages {

    private static List<PersonnageInterface> personnages = new ArrayList<>();

    public static void main(String[] args) {
        URL path = GestionPersonnages.class.getClassLoader().getResource("personnages.csv");
        if (path == null) {
            throw new RuntimeException("Impossible de trouver le fichier [personnages.csv]\n Avez-vous défini un dossier ressources ?");
        }

        //charger les personnages
        System.out.println("\n\n------Chargement des personnages------");
        try {
            chargerPersonnages(FileToStr.lireCsv(path.getPath()));
        } catch (UnknowTypePersonnageException e) {
            System.out.println(e);
        }

        //afficher les personnages
        System.out.println("\n\n------Affichage des personnages------");
        afficherPersonnages();

        //Creer un combat aléatoire
        System.out.println("\n\n------Lancement d'un combat aléatoire------");
        creerCombatAleatoire();
    }


    public static void chargerPersonnages(String[] persos) throws UnknowTypePersonnageException {
        for (String perso : persos) {
            String[] stats = perso.split(";");
            switch (stats[0]) {
                case "G" -> {
                    Guerrier monGuerrier = new Guerrier(stats[1], Integer.parseInt(stats[2]), Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), Integer.parseInt(stats[7]));
                    personnages.add(monGuerrier);
                }
                case "M" -> {
                    Mage monMage = new Mage(stats[1], Integer.parseInt(stats[2]), Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), Integer.parseInt(stats[7]));
                    personnages.add(monMage);
                }
                case "S" -> {
                    Soigneur monSoigneur = new Soigneur(stats[1], Integer.parseInt(stats[2]), Integer.parseInt(stats[3]),
                            Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), Integer.parseInt(stats[7]));
                    personnages.add(monSoigneur);
                }
                default -> throw new UnknowTypePersonnageException(stats[0]);
            }
        }
    }

    public static void afficherPersonnages() {
        for (PersonnageInterface perso : personnages) {
            System.out.println(perso.toString());
        }
    }

    private static void creerCombatAleatoire() {
        Random random = new Random();
        int playerOneIndex = random.nextInt(0, personnages.size());
        int playerTwoIndex = random.nextInt(0, personnages.size());
        while (playerOneIndex == playerTwoIndex) {
            playerTwoIndex = random.nextInt(0, personnages.size());
        }
        Personnage playerOne = (Personnage)personnages.get(playerOneIndex);
        Personnage playerTwo = (Personnage)personnages.get(playerTwoIndex);
        System.out.println("Combat entre les deux personnages suivants :");
        System.out.println("\t" + playerOne.getName() + " VS " + playerTwo.getName());
        System.out.println();
        boolean newTurn = true;
        Personnage activePlayer;
        Personnage otherPlayer;
        while (noWinner(playerOne, playerTwo)) {
            if (newTurn) {
                activePlayer = playerOne;
                otherPlayer = playerTwo;
                newTurn = false;
            } else {
                activePlayer = playerTwo;
                otherPlayer = playerOne;
                newTurn = true;
            }
            switch (random.nextInt(0, 2)) {
                case 0 -> {
                    Integer dmg = activePlayer.attack - otherPlayer.getDefense();
                    if (dmg > 0) {
                        otherPlayer.setHealth(otherPlayer.getHealth() - dmg);
                        System.out.println(activePlayer.getName() + " attaque et fait " + dmg + "points de dégat.");
                    } else {
                        System.out.println(activePlayer.getName() + " attaque mais ne fait aucun dégats. pfff le nul");
                    }
                }
                case 1 -> {
                    activePlayer.defend();
                }
                case 2 -> {
                    activePlayer.special();
                }
            }
        }
        System.out.println("Fin du combat");
        resultBattle(playerOne, playerTwo);
    }


    private static boolean noWinner(Personnage playerOne, Personnage playerTwo) {
        return playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerOne.didDmg && playerTwo.didDmg;
    }
    private static void resultBattle(Personnage playerOne, Personnage playerTwo) {
        if (playerOne.getHealth() > 0 && playerTwo.getHealth() <= 0) {
            System.out.println("Victoire de " + playerOne.getName());
        } else if (playerOne.getHealth() <= 0 && playerTwo.getHealth() > 0) {
            System.out.println("Victoire de " + playerTwo.getName());
        } else {
            System.out.println("Victoire de personne : Double KO");
        }
    }
}
