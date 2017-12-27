/**
 * @(#)FfmpegDemo.java, 2017-12-25.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.ffmpeg;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * FfmpegDemo
 *
 * @author lirongqian
 * @since 25/12/2017
 */
public class FfmpegDemo {

    public static void main(String[] args) throws Exception {


//        File source = new File("/Users/mac/Downloads/1.webm");
//        File target = new File("/Users/mac/Downloads/test.mp3");
//        AudioAttributes audio = new AudioAttributes();
//        audio.setCodec("libmp3lame");
//        audio.setBitRate(128000);
//        audio.setSamplingRate(44100);
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setFormat("mp3");
//        attrs.setAudioAttributes(audio);
//        try {
//            Encoder encoder = new Encoder(new MyFFMPEGExecutableLocator());
//            encoder.encode(source, target, attrs);
//            // todo：待回调调用删除
//        } catch (IllegalArgumentException | EncoderException e) {
//            e.printStackTrace();
//        }
        String source = "/Users/mac/Downloads/1.webm";
        String target = "/Users/mac/Downloads/test.mp3";
        String cmd = "ffmpeg -i " + source + " -vn -ab 128k -ar 44100 -y " + target;
        Process exec = Runtime.getRuntime().exec(cmd, null);
        int status = exec.waitFor();
        if (status != 0) {
            System.err.println("Failed to call shell's command and the return status's is: " + status);
        }
    }

}

class MyFFMPEGExecutableLocator extends FFMPEGLocator {

    @Override
    public String getFFMPEGExecutablePath() {
        return "/usr/local/Cellar/ffmpeg/3.4.1/bin/ffmpeg";
    }
}

