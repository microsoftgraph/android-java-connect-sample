package com.microsoft.graph.connect;



interface AuthenticationCallback<T> {
    void onSuccess(T data);
    void onError(Exception e);
}
