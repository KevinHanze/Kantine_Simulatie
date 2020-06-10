
/**
 * class Student - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (09-06-2020)
 */
public class Student extends Persoon
{
    // instance variables - vervang deze door jouw variabelen
    private String studentNummer;
    private String studieRichting;

    /**
     * Constructor voor objects van class Student
     */
     public Student(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, String studentnummer, String studierichting)
    {
    super(bsn,voornaam,achternaam,geboorteDag,geboorteMaand,geboorteJaar,geslacht);
    studentNummer = studentnummer;
    studieRichting = studierichting; 
    }
    
    public Student(){
        
    }
    
    public String getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(String studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }
}
