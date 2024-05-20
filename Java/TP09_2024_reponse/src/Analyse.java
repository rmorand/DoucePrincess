public class Analyse {
    protected int analyseID;
    protected int patientID;
    protected int patientAge;   // A Rajouter

    public Analyse(int analyseID, int patientID, int patientAge) {
        this.analyseID = analyseID;
        this.patientID = patientID;
        this.patientAge = patientAge;
    }

    public boolean isProblematic() {
        return true;
    }


    public int getPatientID(){
        return this.patientID;
    }


}
