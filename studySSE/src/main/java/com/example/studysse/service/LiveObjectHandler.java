package com.example.studysse.service;

import com.example.studysse.model.LiveObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Service
public class LiveObjectHandler {
    private final List<Consumer<LiveObject>> listeners = new CopyOnWriteArrayList<>();

    public void subscribe(Consumer<LiveObject> listener) {
        listeners.add(listener);
    }

    public void publish(LiveObject liveObject) {
        listeners.forEach(listener -> listener.accept(liveObject));
    }

}