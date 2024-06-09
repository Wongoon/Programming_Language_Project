import java.util.*;

public class InternetCafe {
    Seat[][] seats;
    List<Member> memberList;

    public InternetCafe() {
        memberList = new ArrayList<>();
        Member admin = new Member("admin", "2024661107");
        memberList.add(admin);
    }

    public void LogIn(Scanner sc) {
        Print.ClearConsole();
        Print.print();
        System.out.print("아이디 : ");
        String id = sc.next();

        System.out.print("비밀번호 : ");
        String pw = sc.next();
        Print.print();
        for (Member member : memberList) {
            if (member.GetId().equals(id) && member.CheckPW(pw)) {
                System.out.println("로그인 성공");
                if (id.equals("admin")) {
                    AdminMenu(sc);
                }
                else {
                    MemberMenu(sc, member);
                }
                return;
            }
        }
        System.out.println("로그인 실패");
    }

    public void Register(Scanner sc) {
        Print.ClearConsole();
        Print.print();
        System.out.print("아이디 : ");
        String id = sc.next();
        String pw;
        boolean overlap = false;

        for (Member member : memberList) {
            if (member.GetId().equals(id)) {
                overlap = true;
            }
        }

        if (overlap) {
            System.out.println("아이디가 중복입니다.");
        }
        else {
            System.out.print("비밀번호 : ");
            pw = sc.next();
            AddMember(id, pw);
            Print.print();
            System.out.println("회원가입이 완료되었습니다.");
        }
    }

    public void AddMember(String id, String pw) {
        Member member = new Member(id, pw);
        memberList.add(member);
    }

    public void MemberMenu(Scanner sc, Member member) {
        boolean running = true;
        while (running) {
            Print.ClearConsole();
            Print.print();
            System.out.println("현재 아이디 : " + member.GetId());
            System.out.println("1 : 시간 충전");
            System.out.println("2 : 자리 예약");
            System.out.println("3 : 로그아웃");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            Print.print();
            switch (choice) {
                case 1:
                    ChargeTime(sc, member);
                    break;
                case 2:
                    ReserveSeat(sc, member);
                    break;
                case 3:
                    running = false;
                    System.out.println("로그아웃 되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    public void ChargeTime(Scanner sc, Member member) {
        System.out.print("충전할 시간(분) : ");
        int minutes = sc.nextInt();
        member.AddChargeTime(minutes);
        System.out.println(minutes + "분 충전이 완료되었습니다.");
    }

    public void ReserveSeat(Scanner sc, Member member) {
        System.out.print("예약할 좌석의 X 좌표 : ");
        int x = sc.nextInt();
        System.out.print("예약할 좌석의 Y 좌표 : ");
        int y = sc.nextInt();

        if (x >= 0 && x < seats.length && y >= 0 && y < seats[0].length && !seats[x][y].IsUsed()) {
            seats[x][y].SetUsed(true);
            System.out.println("좌석 예약이 완료되었습니다.");
        }
        else if (seats[x][y].IsUsed()) {
            System.out.println("이미 사용 중입니다.");
        }
        else {
            System.out.println("잘못된 좌석 번호입니다.");
        }
    }

    public void AdminMenu(Scanner sc) {
        boolean running = true;
        Print.ClearConsole();
        while (running) {
            Print.print();
            System.out.println("1 : 좌석 조회");
            System.out.println("2 : 회원 목록");
            System.out.println("3 : 좌석 설정");
            System.out.println("4 : 로그아웃");
            System.out.print("선택 : ");
            int choice = sc.nextInt();
            Print.print();
            switch (choice) {
                case 1:
                    ViewSeats();
                    break;
                case 2:
                    ViewMembers();
                    break;
                case 3:
                    SetSeats(sc);
                    break;
                case 4:
                    running = false;
                    System.out.println("관리자 로그아웃 되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    public void ViewSeats() {
        if (seats == null) {
            System.out.println("좌석이 설정되지 않았습니다.");
            return;
        }
        
        System.out.println("현재 채워진 좌석 : ");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].IsUsed()) {
                    System.out.printf("좌석 (%d, %d)\n", i, j);
                }
            }
        }
    }

    public void ViewMembers() {
        System.out.println("회원 목록:");
        for (Member member : memberList) {
            System.out.printf("ID: %s, 충전 시간: %d분\n", member.GetId(), member.GetChargeTime());
        }
    }

    public void SetSeats(Scanner sc) {
        System.out.print("좌석 행의 수를 입력하세요: ");
        int rows = sc.nextInt();
        System.out.print("좌석 열의 수를 입력하세요: ");
        int cols = sc.nextInt();
        setSeats(rows, cols);
    }

    public void setSeats(int rows, int cols) {
        seats = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
        System.out.println("좌석 설정이 완료되었습니다.");
        System.out.println(rows + " X " + cols);
    }
}
