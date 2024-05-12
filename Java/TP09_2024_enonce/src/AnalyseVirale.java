import java.util.Objects;

public class AnalyseVirale extends Analyse {

    private final String nomVirus;
    private boolean valeurAnalyse;
    public AnalyseVirale(String id, String nomVirus, String result, String age, String patient) {
        this.analyseID = Integer.parseInt(id);
        this.nomVirus = nomVirus;
        parseResult(result);
        this.patientAge = Integer.parseInt(age);
        this.patientID = Integer.parseInt(patient);
    }

    @Override
    public boolean isProblematic() {
        return valeurAnalyse;
    }

    private void parseResult(String result){
        if (Objects.equals(result, "POSITIF")){
            this.valeurAnalyse = true;
        } else {
            this.valeurAnalyse = false;
        }
    }

    private String showResult(){
        if (isProblematic()){
            return "OUI";
        } else {
            return "NON";
        }
    }

    @Override
    public String toString() {
        String description = super.toString();
        description += " Virus " + this.nomVirus + " " + showResult();
        return description;
    }
}
