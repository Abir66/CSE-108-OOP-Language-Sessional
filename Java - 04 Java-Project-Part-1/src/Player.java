public class Player {
    String name;
    Country country;
    Club club;
    int age;
    int number;
    String position;
    double height;
    double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
        country.addPlayer(this);
    }

    public Club getClub() {
        return club;
    }

    /**
     * Sets the club
     * Calls club.addPlayer
     * Example : Messi.addClub(Barca)
     * @param club The club of the player
     */
    public void setClub(Club club) {
        this.club = club;
        club.addPlayer(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    /**
     * <h3>Shows general information about a player</h3>
     * Name, Country, Club, Age, Height, Position, Number. and Salary
     */
    public void showPlayerInfo(){

//        System.out.println("Name        :  " + name);
//        System.out.println("Country     :  " + country.getName());
//        System.out.println("Club        :  " + club.getName());
//        System.out.println("Age         :  " + age);
//        System.out.println("Height      :  " + height);
//        System.out.println("Position    :  " + position);
//        System.out.println("Position    :  " + number);
//        System.out.println("Salary      :  " + salary);
//        System.out.println("");


        //System.out.println(name + " -- " + club.getName() +" -- " + country.getName() + " -- " + position + " -- " + age + " -- " + height + " -- " + salary);
//        System.out.println(name + " -- " + club.getName() +" -- " + country.getName());
//        System.out.println(position + "-" + number + " -- " + age + " yrs -- " + height + " meters -- " + salary + " $");
//        System.out.println("--------------------------------------------------------------------");
        System.out.printf("  %25s %20s %15s ",name,club.getName(),country.getName());
        System.out.printf("%15s , %-3d %3d yrs %5.2f meters %10.2f $\n",position,number,age,height,salary);
        //System.out.println("----------------------------------------------------------------------------------------------------------------------------");


    }


}
