import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * @Author: Stalary
 * @Description:
 * @Date: 2017/10/14
 */
public class Test {

    public static void main(String[] args) throws Exception {

        File source = new File("/Users/mac/Downloads/1.mp3");
        File target = new File("/Users/mac/Downloads/test.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        try {
            Encoder encoder = new Encoder(new MyFFMPEGExecutableLocator());
            encoder.encode(source, target, attrs);
            Thread.sleep(5000);
            target.delete();
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
    }

}

class MyFFMPEGExecutableLocator extends FFMPEGLocator {

    @Override
    public String getFFMPEGExecutablePath() {
        return "/usr/local/Cellar/ffmpeg/3.4.1/bin/ffmpeg";
    }
}

