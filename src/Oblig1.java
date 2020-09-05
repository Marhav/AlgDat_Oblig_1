import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1(){} //Stanser instansiering av klasse.

    //Oppgave1: Finn største tall
    /*
    Vi identifiserer at teknikken som kreves på denne oppgaven er samme algoritmen som i en bubblesort med en
    iterasjon. Dette impliserer at
    - Flest ombyttinger vil foregå når maks verdien befinner seg i indeks 0
    - Færrest ombyttinger vil foregå når listen er sotert
    - I gjennomsnitt vil det foregå N ombyttinger hvor N er summen av alle tall i formen 1/k hvor k = 2 til n gitt at
     tabellen inneholder n > 1 elementer (Setning 1.1.6.a) i kompendiet benyttet i kurset). Denne summen vil nærme
     seg den n-te harmoniske tallet H_n

     Maks metodene vi har sett på tidligere har alle måtte sjekket igjennom tabellen minst en gang. Det er ingen
     unntak for denne maks metoden her som vi har implementert. De alle har hatt en tids-kompleksitet på O(n).
     */
    public static int maks(int[] a){
        if(a.length == 0)
            throw new NoSuchElementException("Tabellen er tom!"); //Kaster avvik dersom tabellen er tom.

        if(a.length == 1)
            return a[0]; //Dersom tabellen inneholder ett element returner denne verdien.

        ombyttinger(a); //Dersom tabellen inneholder mer enn ett element bruk metoden ombyttinger.

        return a[a.length-1]; //returner siste verdi i tabellen a.
    }

    public static int ombyttinger(int[] a){
        if(a.length == 0)
            throw new NoSuchElementException("Tabellen er tom!"); //Kaster avvik dersom tabellen er tom.

        if(a.length == 1)
            return 0; //Dersom tabellen bare inneholder ett element så er det ingen ombyttinger som blir gjort.

        int ombyttinger = 0; //Initialiserer antall ombyttinger.

        for(int i = 0; i < a.length - 1; i++){ //Går igjennom array
            if(a[i] > a[i+1]){ //Dersom nåværende verdi er større enn neste verdi
                bytt(a, i, i+1); //Bytt plass på nåværende og neste verdi
                ombyttinger++; //Øker antall ombytting med 1
            }
        }

        return ombyttinger; //Returnerer antall ombyttinger
    }

    //Oppgave2: Antall ulike (sortert)
    public static int antallUlikeSortert(int[] a){
        return 0; //<--- Endre på returnert variabel når du har programmert ferdig.
    }

    //Oppgave3: Antall ulike (usortert)
    public static int antallUlikeUsortert(int [] a){
        return 0; //<--- Endre på returnert variabel når du har programmert ferdig.
    }

    //Oppgave4: Delsortering
    public static void delsortering(int[] a){
        //Partisjonerer først listen a
        int v = 0; //Initierer venstre-peker
        int h = a.length - 1; //Initierer høyre-peker

        while(v <= h){ //Så lenge pekerne ikke er på samme plass eller har passert hverandre under:
            while(v <=h && (a[v] % 2 == 1 || a[v] % 2 == -1)) v++; //Flytter v mot høyre til den finner et partall
            while(v <=h && a[h] % 2 == 0) h--; //Flytter hø mot venstre til den finner et oddetall
            if(v < h) bytt(a, v++, h--); //Dersom de ikke har passert hverandre så bytt plass og flytt på begge
        }

        quicksort(a, 0, v-1); //Kjører quicksort metoden på oddetallene.
        quicksort(a, v, a.length-1); //Kjører quicksort metoden på partallene.
    }

    //Oppgave5: Rotasjon
    public static void rotasjon(char[] a){
        //HELENE:
        int lengde=a.length;
        if(lengde<2) return; //Om arrayet er tomt eller har en verdi trenger det ikke å roteres

        for (int i=0; i<a.length; i++){ //Løper gjennom arrayet
            bytt(a, i, a.length-1); //For hver a[i] bytter man plass med tallet på slutten av arrayet.
        }


    }

    //Oppgave6: Roter flere plasser
    /*
    Kunne plassert koden over i en for-loop som kjører k ganger for å få til flere rotasjoner,
    men velger å effektivisere koden da den over er mindre effektiv om man skal rotere mange plasser.
     */
    public static void rotasjon(char[] a, int k){
        //HELENE:
        int lengde=a.length;

        if ((k %= lengde)<0) k+=lengde;   //Sjekker om arrayet skal roteres mot venstre.

        for (int v=0, h=lengde-1; v<h; bytt(a, v++,h--));      //Snur a[a:lengde>
        for (int v=0, h=k-1; v<h; bytt(a, v++,h--));           //Snur a[0,k>
        for (int v=k, h=lengde-1; v<h; bytt(a, v++,h--));      //Snur a[k:lengde>

    }

    //Oppgave 7a): Fletting
    public static String flett(String s, String t){

        StringBuilder a=new StringBuilder();

        for (int i=0; i<s.length()||i<t.length(); i++){
            if (i<s.length()){
                a.append(s.charAt(i));
            }
            if (i<t.length()){
                a.append(t.charAt(i));
            }
        }

        return a.toString();

    }

    //Oppgave 7b): Fletting
    public static String flett(String... s){

        StringBuilder a = new StringBuilder();

        //Finner den lengste stringen i arrayet og bruker den lengden som grense for j
        int lengst = s[0].length();
        for (int k = 0; k < s.length; k++) {
            if (s[k].length() > lengst)
                lengst = s[k].length();
        }


        for (int j = 0; j < lengst; j++) {
            for (int i = 0; i < s.length; i++) {
                if (j < s[i].length()) {            //Legger bare til neste bokstav om ordets lengde er mindre enn j(det er flere bokstaver igjen)
                    a.append(s[i].charAt(j));       //Legger til char-en som ligger i ord i, posisjon j
                }
            }
        }

        return a.toString();
    }

    //Oppgave 8: Indeks-sortering
    public static int[] indekssortering(int[] a){
        return null; //<--- Endre på returnert variabel når du har programmert ferdig.
    }

    //Oppgave 9: Tredje minste tall
    public static int[] tredjeMin(int[] a){
        return null; //<--- Endre på returnert variabel når du har programmert ferdig.
    }

    //Oppgave 10: Inneholdt
    public static boolean inneholdt(String a, String b) {
        if (a.isBlank())
            return true; //Hvis a er en tom streng så returnerer den sant ihenhold til oppgaven

        if (a.length() > b.length())
            return false; //Hvis a er lenger enn b så kan den umulig være inneholdt i b

        char[] charrayA = a.toCharArray(); //Konverterer a til en liste av char
        char[] charrayB = b.toCharArray(); //Konverterer b til en liste av char

        int[] intArray = new int[256]; //Lager en int liste for å telle bokstaver i String b

        for(char character : charrayB) intArray[character]++; //Legger til antall bokstaver i String b
        for(char character : charrayA) intArray[character]--; //Legger fjerner antall bokstaver i String a
        for(int integer : intArray) //Sjekker igjennom array
            if(integer < 0) return false; //Er det noen som har blitt fjernet for mye returner false

        return true; //Hvis det ikke er noen problem returner true
    }

    /*---------------------------
    Andre hjelpemetoder under:
    ---------------------------*/

    /*
    Metoden under bytter plass mellom inteks i og indeks j
     */
    private static void bytt(int[] a, int i, int j){
        int temp = a[i]; //Midlertidig lagring av verdi på indeks i
        a[i] = a[j]; //Bytter verdi på indeks i med verdi på indeks j
        a[j] = temp; //Oppdaterer indeks j med midlertidig verdi
    }

    /*
    Metoden under bytter plass mellom indeks i og index j i et char-array
     */
    private static void bytt(char[] a, int i, int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    /*
    Metoden under er en implementering av quicksort algoritmen. Denne kan brukes for å sortere hvilken som helst int
    array.
     */
    private static void quicksort(int[] a, int begin, int end){
        if(begin >= end) return; //Avslutter rekursjon

        int v = begin; //Initialiserer venstre-peker
        int h = end; //Initialiserer høyre-peker

        int m = (v+h)/2; //Finner midt-indeksen
        int pivot = a[m]; //Henter pivot

        bytt(a, m, h--); //Setter bytter pivot og sluttverdien i listen for safe-keeping

        //Partisjonerer listen med pivot som skilleverdi
        while(v <= h){ //Så lenge v og h ikke har passert hverandre kjør koden under.
            while(v <= h && a[v] < pivot) v++; //Inkrementer v per betingelse
            while(v <= h && a[h] >= pivot) h--; //Dekrementerer h per betingelse
            if(v < h) bytt(a, v++, h--); //Bytt dersom v og h ikke står på samme plass eller har passert hverandre
        }

        //venstre-peker skal nå stå på første tallet der alle verdier er større enn pivot.
        bytt(a, v, end); //Bytt tilbake pivot verdi, v er nå pivot sin indeks.

        quicksort(a, begin, v-1); //Kjør quicksort rekursivt på venstre subliste.
        quicksort(a, v+1, end); //Kjør quicksort rekursivt på høyre subliste.
    }
}