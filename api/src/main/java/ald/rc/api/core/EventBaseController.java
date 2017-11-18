package ald.rc.api.core;

public abstract class EventBaseController <T> extends BaseController implements EventHandler{

	protected abstract EventContext getEventContext(T t);
	
	@Override
	public boolean preHandle(EventContext eventContext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EventResult handleEvent(EventContext eventContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postHandle(EventContext eventContext) {
		// TODO Auto-generated method stub
		
	}

}
