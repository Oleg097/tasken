public  class Line {
    String serv;
    String type;
    String pn;

    Line (String string){
        String[] mas = string.split(" ");
        serv = mas[1];
        type = mas[2];
        pn = mas[3];

    }

    public String getServ() {
        return serv;
    }

    public String getType() {
        return type;
    }

    public String getPn() {
        return pn;
    }
}
