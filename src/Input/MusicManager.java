package Input;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/*
 * Created by Anthony Mendez on 9/9/2019.
 */

public class MusicManager {

	//Res.music
    public InputStream musicPath;
    public AudioInputStream audioInput;
    public AudioFormat format;
    public DataLine.Info info;
    public Clip clip;
    
	public void playMusic (String musicLocation) 
	{
		try 
		{
			musicPath = getClass().getResourceAsStream(musicLocation);
            audioInput = AudioSystem.getAudioInputStream(musicPath);
            format = audioInput.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInput);
            clip.loop(0);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

	}
}

