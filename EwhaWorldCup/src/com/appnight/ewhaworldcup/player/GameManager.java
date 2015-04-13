package com.appnight.ewhaworldcup.player;

import java.util.ArrayList;
import java.util.Random;

import com.appnight.ewhaworldcup.R;

public class GameManager {
	private static GameManager instance;

	public static GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	private GameManager() {

	}

	public int nowRound;

	public ArrayList<EwhaPlayer> players = new ArrayList<EwhaPlayer>();

	public void addPlayer(String name, int img, int id, String phone) {
		EwhaPlayer tmpPlayer = new EwhaPlayer();
		tmpPlayer.setName(name);
		tmpPlayer.setUserIndex(id);
		tmpPlayer.setImg(img);
		tmpPlayer.setPhoneNumber(phone);
		players.add(tmpPlayer);
	}

	public void initMangame() {
		players.clear();
		nowRound = 0;
		addPlayer("고민규", R.drawable.man1, 0, "01064139563");
		addPlayer("김동완", R.drawable.man2, 1, "01071230605");
		addPlayer("김동희", R.drawable.man3, 2, "01099178835");
		addPlayer("김재욱", R.drawable.man4, 3, "01044414523");
		addPlayer("김주한", R.drawable.man5, 4, "01041562118");
		addPlayer("박도준", R.drawable.man6, 5, "01055828778");
		addPlayer("박태현1", R.drawable.man7, 6, "01036422977");
		addPlayer("박태현2", R.drawable.man8, 7, "01036422977");
		addPlayer("백재현", R.drawable.man9, 0, "01099256323");
		addPlayer("윤성근", R.drawable.man10, 1, "01089541012");
		addPlayer("이준석", R.drawable.man11, 2, "01027318598");
		addPlayer("임현우", R.drawable.man12, 3, "01036756701");
		addPlayer("정상협", R.drawable.man13, 4, "01045660960");
		addPlayer("조창민", R.drawable.man14, 5, "01089150001");
		addPlayer("최환영", R.drawable.man15, 6, "111");
		addPlayer("한만종", R.drawable.man16, 7, "01088018572");

	}
	
	public void inittmp() {
		players.clear();

		nowRound = 0;
		addPlayer("1", R.drawable.number1, 0, "01064139563");
		addPlayer("2", R.drawable.number2, 1, "01071230605");
		addPlayer("3", R.drawable.number3, 2, "01099178835");
		addPlayer("4", R.drawable.number4, 3, "01044414523");
		addPlayer("5", R.drawable.number5, 4, "01041562118");
		addPlayer("6", R.drawable.number6, 5, "01055828778");
		addPlayer("7", R.drawable.number7, 6, "01036422977");
		addPlayer("8", R.drawable.number8, 7, "01036422977");
		addPlayer("9", R.drawable.number9, 0, "01099256323");
		addPlayer("10", R.drawable.number10, 1, "01089541012");
		addPlayer("11", R.drawable.number11, 2, "01027318598");
		addPlayer("12", R.drawable.number12, 3, "01036756701");
		addPlayer("13", R.drawable.number13, 4, "01045660960");
		addPlayer("14", R.drawable.number14, 5, "01089150001");
		addPlayer("15", R.drawable.number15, 6, "111");
		addPlayer("16", R.drawable.number1, 7, "01088018572");

	}

	public void initWomangame() {
players.clear();
		nowRound = 0;
		addPlayer("길지원", R.drawable.woman1, 0, "01083826844");
		addPlayer("김민지", R.drawable.woman2, 1, "01020887918");
		addPlayer("김혜원", R.drawable.woman3, 2, "01081513865");
		addPlayer("문지현", R.drawable.woman4, 3, "01051885904");
		addPlayer("손민정", R.drawable.woman5, 4, "01066644518");
		addPlayer("신수영", R.drawable.woman6, 5, "01037622171");
		addPlayer("오소연", R.drawable.woman7, 6, "01037808619");
		addPlayer("오지현", R.drawable.woman8, 7, "01051989335");
		addPlayer("이연주", R.drawable.woman9, 0, "01084810141");
		addPlayer("이채린", R.drawable.woman10, 1, "01028712415");
		addPlayer("이한솔", R.drawable.woman11, 2, "01058701248");
		addPlayer("정연경", R.drawable.woman12, 3, "01032109264");
		addPlayer("조혜인", R.drawable.woman13, 4, "01043990908");
		addPlayer("최다은", R.drawable.woman14, 5, "01025521467");
		addPlayer("추재경", R.drawable.woman15, 6, "01029532757");
		addPlayer("한지영", R.drawable.woman16, 7, "01086003787");

	}

	public void randomList() {
		ArrayList mainRandomList = new ArrayList();
		Random ra = new Random();
		int mainSize = players.size(); // 사이즈 따로 구해서
		for (int i = 0; i < mainSize; i++) {
			int rv = ra.nextInt(players.size());
			mainRandomList.add(players.get(rv));
			players.remove(rv);
		}
		players = mainRandomList;
	}

	public void initwoMangame() {

	}
}
