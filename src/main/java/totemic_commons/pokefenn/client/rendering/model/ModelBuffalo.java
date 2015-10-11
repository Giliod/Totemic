// Date: 26.09.2015 20:56:20
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package totemic_commons.pokefenn.client.rendering.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import totemic_commons.pokefenn.entity.animal.EntityBuffalo;

public class ModelBuffalo extends ModelBase
{
    // fields
    private ModelRenderer tailhairs;
    private ModelRenderer hoof1;
    private ModelRenderer leg1;
    private ModelRenderer leg3;
    private ModelRenderer hoof3;
    private ModelRenderer leg2;
    private ModelRenderer hoof2;
    private ModelRenderer leg4;
    private ModelRenderer hoof4;
    private ModelRenderer back;
    private ModelRenderer tail;
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer hornbase2;
    private ModelRenderer horn3;
    private ModelRenderer horn1;
    private ModelRenderer horn2;
    private ModelRenderer hornbase1;
    private ModelRenderer horn4;
    private ModelRenderer horn5;
    private ModelRenderer horn6;

    public ModelBuffalo()
    {
        textureWidth = 128;
        textureHeight = 128;

        tailhairs = new ModelRenderer(this, 47, 109);
        tailhairs.addBox(-1F, 0F, -10.5F, 2, 1, 1);
        tailhairs.setRotationPoint(0F, 7F, 12F);
        tailhairs.setTextureSize(128, 128);
        tailhairs.mirror = true;
        setRotation(tailhairs, 1.48353F, 0F, 0F);
        hoof1 = new ModelRenderer(this, 80, 116);
        hoof1.addBox(-0.5F, 8F, 0F, 3, 6, 3);
        hoof1.setRotationPoint(4F, 10F, -5F);
        hoof1.setTextureSize(128, 128);
        hoof1.mirror = true;
        setRotation(hoof1, 0F, 0F, 0F);
        hoof1.mirror = false;
        leg1 = new ModelRenderer(this, 80, 100);
        leg1.addBox(-1F, 0F, -3F, 4, 11, 5);
        leg1.setRotationPoint(4F, 10F, -5F);
        leg1.setTextureSize(128, 128);
        leg1.mirror = true;
        setRotation(leg1, 0.1396263F, 0F, 0F);
        leg1.mirror = false;
        leg3 = new ModelRenderer(this, 1, 111);
        leg3.addBox(-1F, 0F, -3F, 4, 8, 4);
        leg3.setRotationPoint(4F, 10F, 10F);
        leg3.setTextureSize(128, 128);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg3.mirror = false;
        hoof3 = new ModelRenderer(this, 0, 100);
        hoof3.addBox(-0.5F, 8F, -2F, 3, 6, 3);
        hoof3.setRotationPoint(4F, 10F, 10F);
        hoof3.setTextureSize(128, 128);
        hoof3.mirror = true;
        setRotation(hoof3, 0F, 0F, 0F);
        hoof3.mirror = false;
        leg2 = new ModelRenderer(this, 80, 100);
        leg2.addBox(-3F, 0F, -3F, 4, 11, 5);
        leg2.setRotationPoint(-4F, 10F, -5F);
        leg2.setTextureSize(128, 128);
        leg2.mirror = true;
        setRotation(leg2, 0.1396263F, 0F, 0F);
        hoof2 = new ModelRenderer(this, 80, 116);
        hoof2.addBox(-2.5F, 8F, 0F, 3, 6, 3);
        hoof2.setRotationPoint(-4F, 10F, -5F);
        hoof2.setTextureSize(128, 128);
        hoof2.mirror = true;
        setRotation(hoof2, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 1, 111);
        leg4.addBox(-3F, 0F, -3F, 4, 8, 4);
        leg4.setRotationPoint(-4F, 10F, 10F);
        leg4.setTextureSize(128, 128);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        hoof4 = new ModelRenderer(this, 0, 100);
        hoof4.addBox(-2.5F, 8F, -2F, 3, 6, 3);
        hoof4.setRotationPoint(-4F, 10F, 10F);
        hoof4.setTextureSize(128, 128);
        hoof4.mirror = true;
        setRotation(hoof4, 0F, 0F, 0F);
        back = new ModelRenderer(this, 69, 4);
        back.addBox(-5.5F, 0F, -8.5F, 11, 10, 12);
        back.setRotationPoint(0F, 7F, 2F);
        back.setTextureSize(128, 128);
        back.mirror = true;
        setRotation(back, 1.48353F, 0F, 0F);
        tail = new ModelRenderer(this, 40, 100);
        tail.addBox(-1F, 0F, -9.5F, 2, 1, 8);
        tail.setRotationPoint(0F, 7F, 12F);
        tail.setTextureSize(128, 128);
        tail.mirror = true;
        setRotation(tail, 1.48353F, 0F, 0F);
        body = new ModelRenderer(this, 18, 4);
        body.addBox(-6F, -10F, -9F, 12, 10, 13);
        body.setRotationPoint(0F, 7F, 2F);
        body.setTextureSize(128, 128);
        body.mirror = true;
        setRotation(body, 1.48353F, 0F, 0F);
        head = new ModelRenderer(this, 26, 34);
        head.addBox(-4.5F, -7F, -7F, 9, 7, 9);
        head.setRotationPoint(0F, 6F, -7F);
        head.setTextureSize(128, 128);
        head.mirror = true;
        setRotation(head, 1.570796F, 0F, 0F);
        hornbase2 = new ModelRenderer(this, 18, 95);
        hornbase2.addBox(3.5F, -4F, -1F, 4, 2, 2);
        hornbase2.setRotationPoint(0F, 6F, -7F);
        hornbase2.setTextureSize(128, 128);
        hornbase2.mirror = true;
        setRotation(hornbase2, 1.570796F, 0F, 0F);
        hornbase2.mirror = false;
        horn3 = new ModelRenderer(this, 18, 73);
        horn3.addBox(5.5F, -4F, 5F, 1, 1, 1);
        horn3.setRotationPoint(0F, 6F, -7F);
        horn3.setTextureSize(128, 128);
        horn3.mirror = true;
        setRotation(horn3, 1.570796F, 0F, 0F);
        horn3.mirror = false;
        horn1 = new ModelRenderer(this, 18, 86);
        horn1.addBox(6.5F, -4F, 0F, 2, 2, 4);
        horn1.setRotationPoint(0F, 6F, -7F);
        horn1.setTextureSize(128, 128);
        horn1.mirror = true;
        setRotation(horn1, 1.570796F, 0F, 0F);
        horn1.mirror = false;
        horn2 = new ModelRenderer(this, 18, 80);
        horn2.addBox(5.5F, -4F, 2F, 2, 2, 3);
        horn2.setRotationPoint(0F, 6F, -7F);
        horn2.setTextureSize(128, 128);
        horn2.mirror = true;
        setRotation(horn2, 1.570796F, 0F, 0F);
        horn2.mirror = false;
        hornbase1 = new ModelRenderer(this, 18, 95);
        hornbase1.addBox(-7.5F, -4F, -1F, 4, 2, 2);
        hornbase1.setRotationPoint(0F, 6F, -7F);
        hornbase1.setTextureSize(128, 128);
        hornbase1.mirror = true;
        setRotation(hornbase1, 1.570796F, 0F, 0F);
        horn4 = new ModelRenderer(this, 18, 86);
        horn4.addBox(-8.5F, -4F, 0F, 2, 2, 4);
        horn4.setRotationPoint(0F, 6F, -7F);
        horn4.setTextureSize(128, 128);
        horn4.mirror = true;
        setRotation(horn4, 1.570796F, 0F, 0F);
        horn5 = new ModelRenderer(this, 18, 80);
        horn5.addBox(-7.5F, -4F, 2F, 2, 2, 3);
        horn5.setRotationPoint(0F, 6F, -7F);
        horn5.setTextureSize(128, 128);
        horn5.mirror = true;
        setRotation(horn5, 1.570796F, 0F, 0F);
        horn6 = new ModelRenderer(this, 18, 73);
        horn6.addBox(-6.5F, -4F, 5F, 1, 1, 1);
        horn6.setRotationPoint(0F, 6F, -7F);
        horn6.setTextureSize(128, 128);
        horn6.mirror = true;
        setRotation(horn6, 1.570796F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float scale = 1.0F + 0.5F * ((EntityBuffalo)entity).getRelativeAge();

        GL11.glPushMatrix();
        GL11.glTranslatef(0, 1.5F * (1.0F - scale), 0);
        GL11.glScalef(scale, scale, scale);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        if(isChild)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 6.0F * f5, 4.0F * f5);
        }

        head.render(f5);
        hornbase1.render(f5);
        hornbase2.render(f5);
        horn1.render(f5);
        horn2.render(f5);
        horn3.render(f5);
        horn4.render(f5);
        horn5.render(f5);
        horn6.render(f5);

        if(isChild)
        {
            float childScale = 0.5F;
            GL11.glPopMatrix();
            GL11.glScalef(childScale, childScale, childScale);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        }

        tailhairs.render(f5);
        hoof1.render(f5);
        leg1.render(f5);
        leg3.render(f5);
        hoof3.render(f5);
        leg2.render(f5);
        hoof2.render(f5);
        leg4.render(f5);
        hoof4.render(f5);
        back.render(f5);
        tail.render(f5);
        body.render(f5);

        GL11.glPopMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        head.rotateAngleX = f4 / (180F / (float)Math.PI) + ((float)Math.PI / 2F);
        hornbase1.rotateAngleX = hornbase2.rotateAngleX = horn1.rotateAngleX = horn2.rotateAngleX = horn3.rotateAngleX
                = horn4.rotateAngleX = horn5.rotateAngleX = horn6.rotateAngleX = head.rotateAngleX;

        head.rotateAngleY = hornbase1.rotateAngleY = hornbase2.rotateAngleY = horn1.rotateAngleY = horn2.rotateAngleY = horn3.rotateAngleY
                = horn4.rotateAngleY = horn5.rotateAngleY = horn6.rotateAngleY = f3 / (180F / (float)Math.PI);

        hoof1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg1.rotateAngleX = hoof1.rotateAngleX + ((float)Math.PI * 8F / 180F);
        hoof2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        leg2.rotateAngleX = hoof2.rotateAngleX + ((float)Math.PI * 8F / 180F);

        leg3.rotateAngleX = hoof3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        leg4.rotateAngleX = hoof4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }

}
