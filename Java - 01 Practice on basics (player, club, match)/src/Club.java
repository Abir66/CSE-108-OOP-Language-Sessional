public class Club {
    private int id;
    private String name;
    private Player[] players;
    // add your code here
    private int playerCount = 0;

	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
	
	// add your code here
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player p){
        players[playerCount] = p;
        playerCount++;
    }

    public Player getMaxSalaryPlayer(){
        int maxId = 0;
        for (int i = 0; i < playerCount; i++) {
            if(players[i].getSalary() > players[maxId].getSalary()){
                maxId = i;
            }
        }
        return players[maxId];
    }

}