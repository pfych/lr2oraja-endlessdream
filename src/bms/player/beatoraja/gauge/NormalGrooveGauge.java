package bms.player.beatoraja.gauge;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import bms.model.BMSModel;
import bms.player.beatoraja.PlaySkin;

public class NormalGrooveGauge extends GrooveGauge {

	private float[] gauge;
	
	public NormalGrooveGauge(BMSModel model) {
		super(2,100, 20, 80, CLEARTYPE_NORMAL);
		float g = (float) (model.getTotal() / model.getTotalNotes());
		gauge = new float[] { g, g, g / 2, -2.0f, -6.0f, -2.0f };
	}
	
	@Override
	public void update(int judge) {
		this.setValue(this.getValue() + gauge[judge]);
	}

	@Override
	public void draw(PlaySkin skin, SpriteBatch sprite, float x, float y, float w, float h) {
		sprite.begin();
		for(int i = 2; i <= 100 && i <= getValue(); i+=2) {
			if (i < 80) {
				sprite.draw(skin.getGauge()[0], x + w * (i - 2) / 100,
						y, w / 50, h);
			} else {
				sprite.draw(skin.getGauge()[1], x + w * (i - 2) / 100,
						y, w / 50, h);
			}
		}
		sprite.end();
	}

	@Override
	public float getGaugeValue(int judge) {
		return gauge[judge];
	}
}
