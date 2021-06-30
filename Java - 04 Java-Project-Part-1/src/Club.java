import java.util.ArrayList;
import java.util.List;

public class Club {

    String name;
    List<Player> players = new ArrayList();

    public Club(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        if (players.contains(player)) return;
        players.add(player);
        player.setClub(this);
    }

    public void showPlayerInfo() {
        for (Player p : players) p.showPlayerInfo();
    }

    public int playerCount() {
        return players.size();
    }

    public double totalYearlySalary() {
        double salary = 0;
        for (Player p : players) {
            salary += p.getSalary() * 52;
        }
        return salary;
    }

    public List<Player> maxSalaryPlayers() {
        double maxSalary = 0;
        List<Player> tempPlayers = new ArrayList();
        for (Player p : players) {
            if (p.getSalary() > maxSalary) maxSalary = p.getSalary();
        }
        for (Player p : players) {
            if (p.getSalary() == maxSalary) tempPlayers.add(p);
        }
        return tempPlayers;
    }

    public List<Player> maxHeightPlayers() {
        double maxHeight = 0;
        List<Player> tempPlayers = new ArrayList();
        for (Player p : players) {
            if (p.getHeight() > maxHeight) maxHeight = p.getHeight();
        }
        for (Player p : players) {
            if (p.getHeight() == maxHeight) tempPlayers.add(p);
        }
        return tempPlayers;
    }

    public List<Player> maxAgePlayers() {
        int maxAge = 0;
        List<Player> tempPlayers = new ArrayList();
        for (Player p : players) {
            if (p.getAge() > maxAge) maxAge = p.getAge();
        }
        for (Player p : players) {
            if (p.getAge() == maxAge) tempPlayers.add(p);
        }
        return tempPlayers;
    }

    public List<Player> countryPlayers(Country country){
        List<Player> tempPlayers = new ArrayList();
        for (Player p : players){
            if (p.getCountry() == country) tempPlayers.add(p);
        }
        return tempPlayers;
    }

    public List<Player> countryPlayers(List<Country> country){
        List<Player> tempPlayers = new ArrayList();
        for(Country c : country){
            tempPlayers.addAll(countryPlayers(c));
        }
        return tempPlayers;
    }

    public Player checkNumber(int number){
        for(Player player: players){
            if (player.getNumber()==number) return player;
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
