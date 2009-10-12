package org.wubo.media.client.events;

public interface Action {
	public void onSuccess();
	public void onFailure(Throwable exception);
}
