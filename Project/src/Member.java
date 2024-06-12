public class Member{
    String id;
    String pw;
    int chargeTime;
    int entranceTime;
    int leaveTime;
    int x;
    int y;

    public Member(String id, String pw){
        this.id = id;
        this.pw = pw;
        this.chargeTime = 0;
        this.entranceTime = -1;
        this.leaveTime = -1;
        this.x = -1;
        this.y = -1;
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
        return this.chargeTime;
    }

    public void SetX(int x) {
        this.x = x;
    }

    public void SetY(int y) {
        this.y = y;
    }

    public int GetX() {
        return this.x;
    }

    public int GetY() {
        return this.y;
    }

    public void SubtractChargeTime(int minutes) {
        if (this.chargeTime >= minutes) {
            this.chargeTime -= minutes;
        }
        else {
            this.chargeTime = 0;
        }
    }
}