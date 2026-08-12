package kawaii.boze.addon.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kawaii.boze.addon.KawaiiAddon;
import kawaii.boze.addon.modules.MapCensor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MapRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapRenderer.class)
public class MapRendererMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onDraw(MapRenderState mapRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, boolean showOnlyFrame, int lightCoords, CallbackInfo ci) {
        MapCensor module = KawaiiAddon.mapCensor;
        if (module == null || !module.isModuleEnabled) return;

        // Cancel the real map so it doesn't leak coordinates
        ci.cancel();

        //vertex stuff
        MultiBufferSource.BufferSource consumers = Minecraft.getInstance().renderBuffers().bufferSource();

        //layer stuff
        RenderType layer = RenderTypes.text(module.getTexture());
        VertexConsumer vertexConsumer = consumers.getBuffer(layer);

        Matrix4f matrix4f = poseStack.last().pose();

        int overlay = OverlayTexture.NO_OVERLAY;
        int lightU = lightCoords & 0xFFFF;
        int lightV = (lightCoords >> 16) & 0xFFFF;

        // Draw the custom PNG over the map area
        vertexConsumer.addVertex(matrix4f, 0f, 128f, -0.01f).setUv(0f, 1f).setOverlay(overlay).setUv2(lightU, lightV).setColor(255, 255, 255, 255).setLight(lightCoords);
        vertexConsumer.addVertex(matrix4f, 128f, 128f, -0.01f).setUv(1f, 1f).setOverlay(overlay).setUv2(lightU, lightV).setColor(255, 255, 255, 255).setLight(lightCoords);
        vertexConsumer.addVertex(matrix4f, 128f, 0f, -0.01f).setUv(1f, 0f).setOverlay(overlay).setUv2(lightU, lightV).setColor(255, 255, 255, 255).setLight(lightCoords);
        vertexConsumer.addVertex(matrix4f, 0f, 0f, -0.01f).setUv(0f, 0f).setOverlay(overlay).setUv2(lightU, lightV).setColor(255, 255, 255, 255).setLight(lightCoords);
        consumers.endBatch();
    }
}
