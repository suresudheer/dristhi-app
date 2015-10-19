package org.ei.telemedicine.doctor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by naveen on 5/20/15.
 */
public class DoctorData {


    private String anmId;
    private String FormInformation;
    private String FormTime;
    private String POCInformation;
    private String PocStatus;
    private String PocTime;
    private String SyncStatus;
    private String VisitType;
    private String villageName;

    private String imgUrl;
//
//    private Bitmap image;
//
//    private PendingConsultantBaseAdapter pendingConsultantBaseAdapter;

    public String getVisitType() {
        return VisitType;
    }

    public void setVisitType(String visitType) {
        VisitType = visitType;
    }

    public String getCaseId() {
        return CaseId;
    }

    public void setCaseId(String caseId) {
        CaseId = caseId;
    }

    public String CaseId;

    public String getAnmId() {
        return anmId;
    }

    public void setAnmId(String anmId) {
        this.anmId = anmId;
    }

    public String getFormInformation() {
        return FormInformation;
    }

    public void setFormInformation(String formInformation) {
        FormInformation = formInformation;
    }

    public String getFormTime() {
        return FormTime;
    }

    public void setFormTime(String formTime) {
        FormTime = formTime;
    }

    public String getPOCInformation() {
        return POCInformation;
    }

    public void setPOCInformation(String POCInformation) {
        this.POCInformation = POCInformation;
    }

    public String getPocStatus() {
        return PocStatus;
    }

    public void setPocStatus(String pocStatus) {
        PocStatus = pocStatus;
    }

    public String getPocTime() {
        return PocTime;
    }

    public void setPocTime(String pocTime) {
        PocTime = pocTime;
    }

    public String getSyncStatus() {
        return SyncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        SyncStatus = syncStatus;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }


    public static Comparator<DoctorData> womanNameComparator = new Comparator<DoctorData>() {

        public int compare(DoctorData s1, DoctorData s2) {
            JSONObject compareformInfoJson = null;
            try {
                compareformInfoJson = new JSONObject(s1.getFormInformation());
                JSONObject currentformInfoJson = new JSONObject(s2.getFormInformation());
                String compareWomanName = compareformInfoJson.has(DoctorFormDataConstants.wife_name) ? compareformInfoJson.getString((DoctorFormDataConstants.wife_name)).toUpperCase() : "";
                String currentWomanName = currentformInfoJson.has(DoctorFormDataConstants.wife_name) ? currentformInfoJson.getString((DoctorFormDataConstants.wife_name)).toUpperCase() : "";
                return compareWomanName.compareTo(currentWomanName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return 0;
            //descending order
            //return StudentName2.compareTo(StudentName1);
        }
    };


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
//
//    public Bitmap getImage() {
//        return image;
//    }
//
//    public void loadImage(PendingConsultantBaseAdapter pendingConsultantBaseAdapter) {
//        this.pendingConsultantBaseAdapter = pendingConsultantBaseAdapter;
//        if (getImgUrl() != null && !getImgUrl().equals("")) {
//            new ImageLoadTask().execute(getImgUrl());
//        }
//    }
//
//    public PendingConsultantBaseAdapter getPendingConsultantBaseAdapter() {
//        return pendingConsultantBaseAdapter;
//    }
//
//    public void setPendingConsultantBaseAdapter(PendingConsultantBaseAdapter pendingConsultantBaseAdapter) {
//        this.pendingConsultantBaseAdapter = pendingConsultantBaseAdapter;
//    }
//
//    public static Bitmap getBitmapFromURL(String src) {
//        try {
//            URL url = new URL(src);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            return myBitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private class ImageLoadTask extends AsyncTask<String, String, Bitmap> {
//
//        @Override
//        protected Bitmap doInBackground(String... params) {
//            Log.e("ImageLoadTask", "Attempting to load image URL: " + params[0]);
//            try {
//                Bitmap b = getBitmapFromURL(params[0]);
//                return b;
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap bitmap) {
//            if (bitmap != null) {
//                Log.i("ImageLoadTask", "Successfully loaded " + anmId + " image");
//                image = bitmap;
//                if (pendingConsultantBaseAdapter != null) {
//                    // WHEN IMAGE IS LOADED NOTIFY THE ADAPTER
//                    NativeDoctorActivity.syncDataAdapter.notifyDataSetChanged();
//
//                }
//            } else {
//                Log.e("ImageLoadTask", "Failed to load " + anmId + " image");
//            }
//
//        }
//}
}
