import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {

    HashMap<String,Country> countries = new HashMap<>();
    HashMap<String,Club> clubs = new HashMap<>();
    List<Player> players = new ArrayList();
    List<Country> countryList = new ArrayList<>();
    List<Club> clubList = new ArrayList<>();

    static Database mainDatabase = new Database();

    private static final String INPUT_FILE_NAME = "players.txt";
    private static final String OUTPUT_FILE_NAME = "players.txt";

    public void addPlayer(Player p) {
        players.add(p);

    }

    public Club addClub(String clubName) {
        Club club = searchClub(clubName);
        if (club != null) return club;
        club = new Club(clubName);
        clubList.add(club);
        return club;
    }

    public Country addCountry(String countryName) {
        Country country = searchCountry(countryName);
        if (country != null) return country;
        country = new Country(countryName);
        countries.put(countryName.strip().toLowerCase(),country);
        countryList.add(country);
        return country;
    }

    public Player searchPlayer(String name) {
        for (Player p : players) {
            if (name.strip().equalsIgnoreCase(p.getName())) {
                return p;
            }
        }
        return null;
    }

    public List<Player> searchPlayer(String[] playerNames) {
        List<Player> l = new ArrayList<>();
        for (String s : playerNames) {
            Player p = searchPlayer(s);
            if (p != null) l.add(p);
        }
        return l;
    }

    public Club searchClub(String clubName) {
        for (Club c : clubList) {
            if (clubName.strip().equalsIgnoreCase(c.getName())) {
                return c;
            }
        }
        return null;
    }

    public List<Club> searchClub(String[] clubNames) {
        List<Club> l = new ArrayList<>();
        for (String s : clubNames) {
            Club c = searchClub(s);
            if (c != null) l.add(c);
        }
        return l;
    }

    public Country searchCountry(String countryName) {
        countryName = countryName.strip().toLowerCase();
        if (countries.containsKey(countryName)){
            return countries.get(countryName);
        }
        return null;
    }

    public List<Country> searchCountry(String[] countryNames) {
        List<Country> l = new ArrayList<>();
        for (String s : countryNames) {
            Country c = searchCountry(s);
            if (c != null) l.add(c);
        }
        return l;
    }

    public void showPlayerInfo() {
        for (Player p : players) p.showPlayerInfo();
    }

    public List<Player> searchPlayerBySalary(double low, double high) {
        List<Player> l = new ArrayList<>();
        for (Player p : players) {
            if (p.getSalary() >= low && p.getSalary() <= high) {
                l.add(p);
            }
        }
        return l;
    }

    public List<Player> searchPlayerByPosition(String pos) {
        List<Player> l = new ArrayList<>();
        for (Player p : players) {
            if (pos.strip().equalsIgnoreCase(p.getPosition())) {
                l.add(p);
            }
        }
        return l;
    }

    public List<Player> searchPlayerByPosition(String[] positions) {
        List<Player> l = new ArrayList<>();
        for (String pos : positions) {
            l.addAll(searchPlayerByPosition(pos));
        }
        return l;
    }

    public void showCountryWiseCount() {
        for (Country c : countryList) {
            System.out.println(c.getName() + " --- " + c.playerCount() + " player(s)");
        }
    }

    public void readFromInputFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player p = new Player();
            Country country = addCountry(tokens[1]);
            Club club = addClub(tokens[4]);

            p.setName(tokens[0]);
            p.setCountry(country);
            p.setClub(club);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setSalary(Double.parseDouble(tokens[7]));
            addPlayer(p);
        }
        br.close();
    }

    public void writeToInputFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Club club : clubList){
            for (Player p : club.getPlayers()){
                bw.write(p.getName() + "," + p.getCountry().getName() + "," + p.getAge() + "," +
                        p.getHeight() + "," + p.getClub().getName() + "," + p.getPosition() + "," +
                        p.getNumber() + "," + p.getSalary());
                bw.write("\n");
            }
        }
        bw.close();
    }

    public List<Player> maxSalaryPlayersFromClub(List<Club> clubs) {
        List<Player> players = new ArrayList<>();
        for (Club club : clubs) {
            List<Player> player2 = club.maxSalaryPlayers();
            if (players.isEmpty()) players = player2;
            else if (player2.get(0).getSalary() > players.get(0).getSalary())
                players = player2;
            else if (player2.get(0).getSalary() == players.get(0).getSalary())
                players.addAll(player2);

        }
        return players;
    }

    public List<Player> maxAgePlayersFromClub(List<Club> clubs) {
        List<Player> players = new ArrayList<>();
        for (Club club : clubs) {
            List<Player> player2 = club.maxAgePlayers();
            if (players.isEmpty()) players = player2;
            else if (player2.get(0).getAge() > players.get(0).getAge())
                players = player2;
            else if (player2.get(0).getAge() == players.get(0).getAge())
                players.addAll(player2);

        }
        return players;
    }

    public List<Player> maxHeightPlayersFromClub(List<Club> clubs) {
        List<Player> players = new ArrayList<>();
        for (Club club : clubs) {
            List<Player> player2 = club.maxHeightPlayers();
            if (players.isEmpty()) players = player2;
            else if (player2.get(0).getHeight() > players.get(0).getHeight())
                players = player2;
            else if (player2.get(0).getHeight() == players.get(0).getHeight())
                players.addAll(player2);

        }
        return players;
    }

}
