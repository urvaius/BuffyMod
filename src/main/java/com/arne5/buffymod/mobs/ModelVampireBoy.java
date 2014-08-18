package com.arne5.buffymod.mobs;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVampireBoy extends ModelBase
{
  //fields
    ModelRenderer boltleft;
    ModelRenderer boltright;
    ModelRenderer leftcuffs;
    ModelRenderer cuffChain;
    ModelRenderer rightcuffs;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

  public ModelVampireBoy()
  {
    textureWidth = 64;
    textureHeight = 32;
   
      boltleft = new ModelRenderer(this, 40, 0);
      boltleft.addBox(0F, 0F, 0F, 2, 2, 1);
      boltleft.setRotationPoint(5F, -4F, -2F);
      boltleft.setTextureSize(64, 32);
      boltleft.mirror = true;
      setRotation(boltleft, 0F, -1.570796F, 0F);
      boltright = new ModelRenderer(this, 40, 0);
      boltright.addBox(0F, 0F, 0F, 2, 2, 1);
      boltright.setRotationPoint(-5F, -4F, 1F);
      boltright.setTextureSize(64, 32);
      boltright.mirror = true;
      setRotation(boltright, 0F, 1.570796F, 0F);
      leftcuffs = new ModelRenderer(this, 24, 0);
      leftcuffs.addBox(-5F, -1F, 0F, 6, 6, 2);
      leftcuffs.setRotationPoint(-4F, 0F, -9F);
      leftcuffs.setTextureSize(64, 32);
      leftcuffs.mirror = true;
      setRotation(leftcuffs, 0F, 0F, 0F);
      cuffChain = new ModelRenderer(this, 40, 3);
      cuffChain.addBox(0F, 0F, 0F, 6, 1, 1);
      cuffChain.setRotationPoint(-3F, 1F, -9F);
      cuffChain.setTextureSize(64, 32);
      cuffChain.mirror = true;
      setRotation(cuffChain, 0F, 0F, 0F);
      rightcuffs = new ModelRenderer(this, 24, 0);
      rightcuffs.addBox(0F, 0F, 0F, 6, 6, 2);
      rightcuffs.setRotationPoint(3F, -1F, -9F);
      rightcuffs.setTextureSize(64, 32);
      rightcuffs.mirror = true;
      setRotation(rightcuffs, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -1.570796F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -1.570796F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
  }
 
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    boltleft.render(f5);
    boltright.render(f5);
    leftcuffs.render(f5);
    cuffChain.render(f5);
    rightcuffs.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
 
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
 
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
 
}
