package http.client;

import java.util.Timer;
import java.util.TimerTask;

public class StartUp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpRequester requester = new HttpRequester();
		String data = requester.getData();
		System.out.println(data);
		requester.postData(data);

		long pause = Constants.PAUSE_TIME;
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, pause);

	}

}
