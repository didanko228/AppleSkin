package squeek.appleskin.helpers;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.util.Util;
import org.lwjgl.sdl.SDLScancode;

public class KeyHelper
{
	public static boolean isCtrlKeyDown()
	{
		// prioritize CONTROL, but allow OPTION as well on Mac (note: GuiScreen's isCtrlKeyDown only checks for the OPTION key on Mac)
		boolean isCtrlKeyDown = InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_LCTRL) || InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_RCTRL);
		if (!isCtrlKeyDown && Util.getPlatform() == Util.OS.OSX)
			isCtrlKeyDown = InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_LGUI) || InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_RGUI);

		return isCtrlKeyDown;
	}

	public static boolean isShiftKeyDown()
	{
		return InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_LSHIFT) || InputConstants.isKeyDown(SDLScancode.SDL_SCANCODE_RSHIFT);
	}
}