package ald.rc.api.core;

public interface EventHandler {
	boolean preHandle(EventContext eventContext);
	EventResult handleEvent(EventContext eventContext);
	void postHandle(EventContext eventContext);
}
