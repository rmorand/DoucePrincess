public class AnalyseSanguine extends Analyse {
    public static final String OK = "";
    public static final String KO = " PAS DANS LA NORME";
    private final int valeurAnalyse;

    public AnalyseSanguine(String id, Object o, String result, String age, String patient) {
        this.analyseID = Integer.parseInt(id);
        this.valeurAnalyse = Integer.parseInt(result);
        this.patientAge = Integer.parseInt(age);
        this.patientID = Integer.parseInt(patient);
    }

    @Override
    public boolean isProblematic() {
        boolean problem;

        if (5 <= getPatientAge() && getPatientAge() <= 10) {
            if (160000 <= valeurAnalyse && valeurAnalyse <= 450000) {
                problem = false;
            } else {
                problem = true;
            }
        } else if (11 <= getPatientAge() && getPatientAge() <= 15) {
            if (160000 <= valeurAnalyse && valeurAnalyse <= 400000) {
                problem = false;
            } else {
                problem = true;
            }
        } else {
            if (160000 <= valeurAnalyse && valeurAnalyse <= 350000) {
                problem = false;
            } else {
                problem = true;
            }
        }
        return problem;
    }

    private String showResult() {
        if (isProblematic()) {
            return KO;
        } else {
            return OK;
        }
    }

    @Override
    public String toString() {
        String description = super.toString();
        description += " Bilan Plaquettes, valeur " + this.valeurAnalyse + showResult();
        return description;
    }

}
