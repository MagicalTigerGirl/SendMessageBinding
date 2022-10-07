package com.example.sendmessagebinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que mando. Al ser User un objeto
 * se debe implementar la interfaz Serializable y Parcelable en el objeto User
 * @author Maria Molina
 * @version 1.0
 */
public class Message implements Serializable, Parcelable {
    private User user;
    private String content;

    public Message(User user, String content) {
        this.user=user;
        this.content=content;
    }

    public Message(User user){
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    /* Por defecto si no se declara un constructor Java implementa el constructor vacío
    public Message(){}
    */

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * En este método devuelve la representación de un objeto
    */

    @NonNull
    @Override
    public String toString() {
        return getUser() + "-> "+getContent();
    }

//region MÉTODOS CREADOS DE LA INTERFAZ PARCELABLE

    protected Message(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(user, i);
        parcel.writeString(content);
    }

    //endregion
}
