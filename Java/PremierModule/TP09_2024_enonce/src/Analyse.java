public abstract class Analyse {

    int analyseID;
    int patientID;
    int patientAge;

    public abstract boolean isProblematic();

    public int getPatientId() {
        return this.patientID;
    }

    protected int getPatientAge(){
        return this.patientAge;
    }

    @Override
    public String toString() {
        return "Analyse " + analyseID + "pour patient " + patientID;
    }
}
