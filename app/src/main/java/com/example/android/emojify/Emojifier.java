package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by clucier on 6/14/17.
 */

public class Emojifier {

    public static void detectFaces(Context context, Bitmap bitmap) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d("Face Detection", "Faces Detected: " + Integer.toString(faces.size()));

        Toast.makeText(context, "Faces Detected: " + Integer.toString(faces.size()), Toast.LENGTH_SHORT).show();

        // Release the detector
        detector.release();

    }
}
