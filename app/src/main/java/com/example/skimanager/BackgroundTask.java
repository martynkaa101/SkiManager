package com.example.skimanager;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

//import android.support.constraint.ConstraintLayout;

public class BackgroundTask extends AsyncTask<String, String, String>{
    private static String[][] data;
    private static String[][] data_lesson;
    String result="";
    Boolean result1=false;

    public Boolean isResult1() {
        return result1;
    }

    public static String[][] getData() {
        return data;
    }

    public static String[][] getData_lesson() {
        return data_lesson;
    }

    Context context;
    BackgroundTask(Context ctx){
        context=ctx;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected String doInBackground(String... strings) {


        String type=strings[0];
        String loginURL="http://10.0.2.2:8080/registration_folder/login.php";
        String regURL="http://10.0.2.2:8080/registration_folder/registration.php";
        String instructorURL="http://10.0.2.2:8080/registration_folder/free_hour.php";
        String lessonURL="http://10.0.2.2:8080/registration_folder/lesson.php";
        String savedLessonURL="http://10.0.2.2:8080/registration_folder/saved_lesson.php";
        String lessonInfoURL="http://10.0.2.2:8080/registration_folder/lesson_info.php";
        String lessonRateURL="http://10.0.2.2:8080/registration_folder/lesson_rate.php";
        String lessonCancelURL="http://10.0.2.2:8080/registration_folder/lesson_cancel.php";
        String passwordChangeURL="http://10.0.2.2:8080/registration_folder/password_change.php";


        if(type.equals("reg")){
            //System.out.println("cos tam sie udalo");
            String imie= strings[1];
            String nazwisko=strings[2];
            String urodziny= strings[3]; //nie wiadomo czy zadziala
            String telefon=strings[4];
            String email=strings[5];
            String haslo=strings[6];
            try{
                URL url= new URL(regURL);
                try{
                    HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream= httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String insert_data = URLEncoder.encode("imie", "UTF-8")+"="+URLEncoder.encode(imie, "UTF-8")+
                            "&"+URLEncoder.encode("nazwisko", "UTF-8")+"="+URLEncoder.encode(nazwisko, "UTF-8")+
                            "&"+URLEncoder.encode("urodziny", "UTF-8")+"="+URLEncoder.encode(urodziny, "UTF-8")+
                            "&"+URLEncoder.encode("telefon", "UTF-8")+"="+URLEncoder.encode(telefon, "UTF-8")+
                            "&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+
                            "&"+URLEncoder.encode("haslo", "UTF-8")+"="+URLEncoder.encode(haslo, "UTF-8");
                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream= httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String line="";
                    StringBuilder stringBuilder= new StringBuilder();
                    while ((line=bufferedReader.readLine())!=null){
                        stringBuilder.append(line).append("\n");

                    }
                    result=stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("login")) {
            String email_login = strings[1];
            String haslo_login = strings[2];
            try {
                URL url = new URL(loginURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String login_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email_login, "UTF-8") +
                            "&" + URLEncoder.encode("haslo", "UTF-8") + "=" + URLEncoder.encode(haslo_login, "UTF-8");
                    bufferedWriter.write(login_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    String res = new String("login success"+"\n");
                    if(result.equals(res)){
                        result1=true;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("instructor")) {
            String instructor = strings[1];
            String year = strings[2];
            String month = strings[3];
            String day = strings[4];
            try {
                URL url = new URL(instructorURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String instructor_data = URLEncoder.encode("instructor", "UTF-8") + "=" + URLEncoder.encode(instructor, "UTF-8") +
                            "&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8") +
                            "&" + URLEncoder.encode("month", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8") +
                            "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");
                    bufferedWriter.write(instructor_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    JSONArray jsonArray = new JSONArray(result);
                    JSONObject jsonObject = null;
                    data = new String[2][jsonArray.length()];

                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        data[0][i] = jsonObject.getString("hour");
                        data[1][i] = jsonObject.getString("free_flag");
                    }
                    return result;
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("lesson")) {
            String instructor = strings[1];
            String year = strings[2];
            String month = strings[3];
            String day = strings[4];
            String hour = strings[5];
            String quantity = strings[6];
            String email1 = strings[7];

            try {
                URL url = new URL(lessonURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String lesson_data = URLEncoder.encode("instructor", "UTF-8") + "=" + URLEncoder.encode(instructor, "UTF-8") +
                            "&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8") +
                            "&" + URLEncoder.encode("month", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8") +
                            "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8") +
                            "&" + URLEncoder.encode("hour", "UTF-8") + "=" + URLEncoder.encode(hour, "UTF-8") +
                            "&" + URLEncoder.encode("quantity", "UTF-8") + "=" + URLEncoder.encode(quantity, "UTF-8");
                    bufferedWriter.write(lesson_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    if(result.equals("lesson saved\n")) {
                        try {
                            URL url1 = new URL(savedLessonURL);
                            try {
                                HttpURLConnection httpURLConnection1 = (HttpURLConnection) url1.openConnection();
                                httpURLConnection1.setRequestMethod("POST");
                                httpURLConnection1.setDoOutput(true);
                                httpURLConnection1.setDoInput(true);
                                OutputStream outputStream1 = httpURLConnection1.getOutputStream();
                                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(outputStream1, "UTF-8");
                                BufferedWriter bufferedWriter1 = new BufferedWriter(outputStreamWriter1);
                                String saved_lesson_data = URLEncoder.encode("instructor", "UTF-8") + "=" + URLEncoder.encode(instructor, "UTF-8") +
                                        "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email1, "UTF-8") +
                                        "&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8") +
                                        "&" + URLEncoder.encode("month", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8") +
                                        "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8") +
                                        "&" + URLEncoder.encode("hour", "UTF-8") + "=" + URLEncoder.encode(hour, "UTF-8");
                                bufferedWriter1.write(saved_lesson_data);
                                bufferedWriter1.flush();
                                bufferedWriter1.close();
                                InputStream inputStream1 = httpURLConnection1.getInputStream();
                                InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream1, "ISO-8859-1");
                                BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);
                                String result1 = "";
                                String line1 = "";
                                StringBuilder stringBuilder1 = new StringBuilder();
                                while ((line1 = bufferedReader1.readLine()) != null) {
                                    stringBuilder1.append(line1).append("\n");

                                }
                                result1 = stringBuilder1.toString();
                                bufferedReader1.close();
                                inputStream1.close();
                                httpURLConnection1.disconnect();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("lesson_info")) {
            String email = strings[1];
            try {
                URL url = new URL(lessonInfoURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String lessonInfo_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
                    bufferedWriter.write(lessonInfo_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    JSONArray jsonArray = new JSONArray(result);
                    JSONObject jsonObject = null;
                    data_lesson = new String[5][jsonArray.length()];

                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        data_lesson[0][i] = jsonObject.getString("instructor");
                        data_lesson[1][i] = jsonObject.getString("year");
                        data_lesson[2][i] = jsonObject.getString("month");
                        data_lesson[3][i] = jsonObject.getString("day");
                        data_lesson[4][i] = jsonObject.getString("hour");
                    }
                    return result;
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("lesson_rate")) {
            String email = strings[1];
            String instructor = strings[2];
            String year = strings[3];
            String month = strings[4];
            String day = strings[5];
            String hour = strings[6];
            String rate = strings[7];

            try {
                URL url = new URL(lessonRateURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String lesson_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") +
                            "&" + URLEncoder.encode("instructor", "UTF-8") + "=" + URLEncoder.encode(instructor, "UTF-8") +
                            "&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8") +
                            "&" + URLEncoder.encode("month", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8") +
                            "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8") +
                            "&" + URLEncoder.encode("hour", "UTF-8") + "=" + URLEncoder.encode(hour, "UTF-8") +
                            "&" + URLEncoder.encode("rate", "UTF-8") + "=" + URLEncoder.encode(rate, "UTF-8");
                    bufferedWriter.write(lesson_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("lesson_cancel")) {
            String email = strings[1];
            String instructor = strings[2];
            String year = strings[3];
            String month = strings[4];
            String day = strings[5];
            String hour = strings[6];

            try {
                URL url = new URL(lessonCancelURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String lesson_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") +
                            "&" + URLEncoder.encode("instructor", "UTF-8") + "=" + URLEncoder.encode(instructor, "UTF-8") +
                            "&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8") +
                            "&" + URLEncoder.encode("month", "UTF-8") + "=" + URLEncoder.encode(month, "UTF-8") +
                            "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8") +
                            "&" + URLEncoder.encode("hour", "UTF-8") + "=" + URLEncoder.encode(hour, "UTF-8");
                    bufferedWriter.write(lesson_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(type.equals("password_change")) {
            String email = strings[1];
            String oldPassword = strings[2];
            String newPassword = strings[3];

            try {
                URL url = new URL(passwordChangeURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String lesson_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") +
                            "&" + URLEncoder.encode("oldPassword", "UTF-8") + "=" + URLEncoder.encode(oldPassword, "UTF-8") +
                            "&" + URLEncoder.encode("newPassword", "UTF-8") + "=" + URLEncoder.encode(newPassword, "UTF-8");
                    bufferedWriter.write(lesson_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");

                    }
                    result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
//super.onPostExecute(s);
    }

}