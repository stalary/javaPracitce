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

