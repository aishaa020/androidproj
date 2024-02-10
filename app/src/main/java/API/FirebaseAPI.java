package API;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project.GitStartedActivity;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.UserProfileActivity;
import com.example.project.loginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import datamodel.User;

public class FirebaseAPI {
    static String URL = "http://192.168.1.2:5000/";
    private RequestQueue queue;

    public  FirebaseAPI(Context context) {
        queue = Volley.newRequestQueue(context);

    }

    public void register(User user,Context context) throws JSONException {
        String url = URL + "user";


        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("name", user.getName());
            jsonParams.put("location", user.getLocation());
            jsonParams.put("birthday", user.getBirthday());
            jsonParams.put("email", user.getEmail());
            jsonParams.put("password", user.getPassword());


            // Building a request
            StringRequest stringRequest = new StringRequest(Request.Method.POST,  URL+"user",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }){
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


             queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }



    }

    public void login(String email,String password,Context context) throws JSONException {



        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("email", email);
            jsonParams.put("password", password);


            // Building a request
            StringRequest stringRequest = new StringRequest(Request.Method.POST,  URL+"login",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equals("false")) {
                                Toast.makeText(context, "wrong confidentials", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                                //change the login to your landing page once you uploaded it to githup
                                Intent intent = new Intent(context, UserProfileActivity.class);
                                intent.putExtra("id",response);
                                startActivity(context, intent, null);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }){
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }



    }

    public void get_user_data(String id,Context context) throws JSONException {
        String url = URL + "profile";


        try {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("id", id);

            StringRequest stringRequest = new StringRequest(Request.Method.POST,  URL+"profile",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ImageView imageView = (ImageView) ((Activity) context).findViewById(R.id.imageView);
                            TextView nameTextView = (TextView) ((Activity) context).findViewById(R.id.name);
                            TextView dateTextView = (TextView) ((Activity) context).findViewById(R.id.date);
                            TextView locationTextView = (TextView) ((Activity) context).findViewById(R.id.location);
                            TextView emailTextView = (TextView) ((Activity) context).findViewById(R.id.email);
                            Button selectImageButton = (Button) ((Activity) context).findViewById(R.id.selectImageButton);

                            try {
                                JSONObject obj = new JSONObject(response);
                                String name = obj.getString("name");
                                String date = obj.getString("birthday");
                                String location = obj.getString("location");
                                String email = obj.getString("email");
                                nameTextView.setText(name);
                                dateTextView.setText(date);
                                locationTextView.setText(location);
                                emailTextView.setText(email);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }){
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }



    }

}

