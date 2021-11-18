import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {

	private int id;
	private String status;
	private Date startTime;
	private Date endTime;
	private static List<Integer> answer;

	public Game() {
		generateAnswer();
	}

	private static void generateAnswer() {
		List<Integer> randomNums = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int randomNumber = (int) (Math.random() * 9) + 1;
			if (randomNums.contains(randomNumber)) {
				while (randomNums.contains(randomNumber)) {
					randomNumber = (int) (Math.random() * 9) + 1;
				}
			}
			randomNums.add(randomNumber);
		}
		answer = randomNums;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<Integer> getAnswer() {
		return answer;
	}

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println(game.getAnswer());
	}

}
