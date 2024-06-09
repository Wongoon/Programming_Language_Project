public class Member{
    String id;
    String pw;
    int chargeTime;
    int entranceTime;
    int leaveTime;

    public Member(String id, String pw){
        this.id = id;
        this.pw = pw;
        this.chargeTime = 0;
        this.entranceTime = -1;
        this.leaveTime = -1;
    }

    public String GetId() {
        return id;
    }

    public boolean CheckPW(String pw) {
        return this.pw.equals(pw);
    }

    public void AddChargeTime(int minutes) {
        this.chargeTime += minutes;
    }

    public void SetEntranceTime(int entranceTime) {
        this.entranceTime = entranceTime;
    }

    public void SetLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int GetChargeTime() {
        return chargeTime;
    }
}