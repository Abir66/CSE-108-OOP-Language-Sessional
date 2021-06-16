public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name;
    private Club[] clubs;
    private int[] homeIndex, awayIndex, clubPoints;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0;
        clubs = new Club[5];
    }

    public void printLeagueInfo() {
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs() {
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for (int i = 0; i < clubCount; i++) {
            System.out.println(clubs[i].getName());
        }
    }

    public void scheduleMatches() {
        matchCount = (clubCount * (clubCount - 1));
        matches = new Match[matchCount];
        homeIndex = new int[matchCount];
        awayIndex = new int[matchCount];
        int matchNo = 0;
        for (int i = 0; i < clubCount; i++) {
            for (int j = 0; j < clubCount; j++) {
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                if (i != j) {
                    homeIndex[matchNo] = i;
                    awayIndex[matchNo] = j;
                    matches[matchNo] = new Match(matchNo, clubs[i], clubs[j]);
                    matchNo++;
                }
            }
        }
    }

    public void simulateMatches() {
        clubPoints = new int[clubCount];
        for (int i = 0; i < matchCount; i++) {
            matches[i].play();
            clubPoints[homeIndex[i]] += matches[i].getHomeTeamPoint();
            clubPoints[awayIndex[i]] += matches[i].getAwayTeamPoint();
        }
    }

    public void showStandings() {
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // followed by printLeagueInfo() meth(carefully observe the output of showStandings() od calls
        // you can use additional arrays if needed
        int[] points = new int[clubCount];
        int[] index = new int[clubCount];
        for (int i = 0; i < clubCount; i++) {
            points[i] = clubPoints[i];
            index[i] = i;
        }
        //sorting
        for (int i = 0; i < clubCount ; i++) {
            int mx = i;
            for (int j = i+1; j < clubCount ; j++) {
               if(points[j] > points[mx]) mx = j;
            }
            int temp = points[i];
            points[i] = points[mx];
            points[mx] = temp;

            temp = index[i];
            index[i] = index[mx];
            index[mx] = temp;
        }

        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        for (int i = 0; i < clubCount; i++) {
            System.out.println(i+1 + ". " + clubs[index[i]].getName() + " " + points[i]);
        }
    }

    // add your methods here, if required

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addClub(Club c) {
        clubs[clubCount] = c;
        clubCount++;
    }

    public void printMatches() {
        for (int i = 0; i < matchCount; i++) {
            matches[i].showResult();
        }
    }

    public void removeClub(Club c) {
        int i;
        for (i = 0; i < clubCount; i++) {
            if (clubs[i] == c) {
                clubCount--;
                break;
            }
        }
        for (; i < clubCount ; i++) {
            clubs[i] = clubs[i + 1];
            clubPoints[i] = clubPoints[i+1];
        }
    }


}

