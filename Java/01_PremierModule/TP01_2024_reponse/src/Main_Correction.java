public class Main_Correction {
    public static void main(String[] args) {
        //main
        Entreprise_Correction heg = new Entreprise_Correction("heg", "rue de Carouge", "publique", 5, 200,"Charles");
        System.out.println(heg);
        heg.changerNbBatiment(20);
        System.out.println(heg.recupererNbBatiment());
        heg.afficherInfos(true);
        heg.afficherInfos(false);
    }
}
