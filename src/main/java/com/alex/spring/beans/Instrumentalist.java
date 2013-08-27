package com.alex.spring.beans;


public class Instrumentalist implements Performer {

	private Instrument instrument;
	private String song;
	public Instrumentalist() {
	}
	
	@Override
	public void perform() throws Exception {
		System.out.println("Play song: " + song);
		instrument.play();
	}

	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public String screamSong(){
		return "SCREAM " + song;
	}
	
	/**
	 * @return the song
	 */
	public String getSong() {
		return song;
	}

	/**
	 * @param song the song to set
	 */
	public void setSong(String song) {
		this.song = song;
	}

}
