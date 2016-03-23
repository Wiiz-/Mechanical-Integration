package mod.mi.common.tile;

import mod.mi.common.mechanical.MechanicalNetwork;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;

public class TileShaft extends TileMechanical
{

    //0 is always in the positive direction
    //1 is always negative
    public EnumFacing[] conns = new EnumFacing[2];
    public EnumFacing.Axis axis = EnumFacing.Axis.Y;

    public float power = 0.0F;
    public float torque = 0.0F;
    public float speed = 0.0F;

    public float angle = 0.0F;
    public float curRot = 0.0F;
    public float prevRot = 0.0F;

    public boolean firstTick = true;

    @Override
    public void update()
    {
        if (firstTick)
        {
            checkAxis();
            firstTick = false;
        }
    }

    public void onBlockActivated()
    {

    }

    public void onNeighborChange()
    {

    }

    public void onBlockPlaced(EntityPlayer player)
    {
        int facing;

        if (player.rotationPitch > 45)
        {
            facing = 5;
        }
        else if (player.rotationPitch < -45)
        {
            facing = 4;
        }
        else
        {
            facing = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        }

        if (facing == 0 || facing == 2)
        {
            this.axis = EnumFacing.Axis.Z;
        }
        else if (facing == 1 || facing == 3)
        {
            this.axis = EnumFacing.Axis.X;
        }
        else if (facing == 4 || facing == 5)
        {
            this.axis = EnumFacing.Axis.Y;
        }

        checkAxis();
    }

    private void checkAxis()
    {
        switch (axis)
        {
            case X:
                if (worldObj.getTileEntity(this.pos.add(-1, 0, 0)) instanceof TileShaft)
                    this.conns[0] = EnumFacing.WEST;
                else
                    this.conns[0] = null;

                if (worldObj.getTileEntity(this.pos.add(1, 0, 0)) instanceof TileShaft)
                    this.conns[1] = EnumFacing.EAST;
                else
                    this.conns[1] = null;
                break;
            case Y:
                if (worldObj.getTileEntity(this.pos.add(0, 1, 0)) instanceof TileShaft)
                    this.conns[0] = EnumFacing.UP;
                else
                    this.conns[0] = null;

                if (worldObj.getTileEntity(this.pos.add(0, -1, 0)) instanceof TileShaft)
                    this.conns[1] = EnumFacing.DOWN;
                else
                    this.conns[1] = null;
                break;
            case Z:
                if (worldObj.getTileEntity(this.pos.add(0, 0, 1)) instanceof TileShaft)
                    this.conns[0] = EnumFacing.NORTH;
                else
                    this.conns[0] = null;

                if (worldObj.getTileEntity(this.pos.add(0, 0, -1)) instanceof TileShaft)
                    this.conns[1] = EnumFacing.SOUTH;
                else
                    this.conns[1] = null;
                break;
            default:
                break;
        }
    }

    @Override
    public void writeNBT(NBTTagCompound nbt)
    {
        nbt.setFloat("power", this.power);
        nbt.setFloat("speed", this.speed);
        nbt.setFloat("torque", this.torque);
        nbt.setFloat("angle", this.angle);
        nbt.setFloat("curRot", this.curRot);
        nbt.setFloat("prevRot", this.prevRot);
    }

    @Override
    public void readNBT(NBTTagCompound nbt)
    {
        this.power = nbt.getFloat("power");
        this.speed = nbt.getFloat("speed");
        this.torque = nbt.getFloat("torque");
        this.angle = nbt.getFloat("angle");
        this.curRot = nbt.getFloat("curRot");
        this.prevRot = nbt.getFloat("prevRot");
    }

    @Override
    public MechanicalNetwork getNetwork()
    {
        return this.network;
    }

    @Override
    public void setNetwork(MechanicalNetwork net)
    {
        this.network = net;
    }

}
