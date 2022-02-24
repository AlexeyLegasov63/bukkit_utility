package your.plugin;

import org.apache.commons.lang3.Validate;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.EulerAngle;

import com.sk89q.worldedit.Vector;

/**
 * Change for your version
 */
import net.minecraft.server.v1_12_R1.Vec3D;

public class Vec3d {
	public static final Vec3d ZERO = new Vec3d();
	
	private double x;
	private double y;
	private double z;
	
	public Vec3d() {
		this.x = 0.0d;
		this.y = 0.0d;
		this.z = 0.0d;
	}
	
	public Vec3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public double getX() {
		return x;
	}
	
	public void setX(double arg0) {
		this.x = arg0;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double arg0) {
		this.y = arg0;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double arg0) {
		this.z = arg0;
	}
	
	/**
	 * @return ArmorStand euler angle
	 */
	public EulerAngle toEuler() {
		return new EulerAngle(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
	}
	
	/**
	 * @return Location at world by name "world" (Standard)
	 */
	public Location toLocation() {
		return toLocation(Bukkit.getWorld("world"));
	}
	
	/**
	 * @return Bukkit location
	 */
	public Location toLocation(World world) {
		Validate.notNull(world, "World cannot be null");
		return new Location(world, x, y, z);
	}
	
	/**
	 * @return Bukkit vector
	 */
	public org.bukkit.util.Vector toVector() {
		return new org.bukkit.util.Vector(x, y, z);
	}
	
	/**
	 * @return NMS vector
	 */
	public Vec3D toNMSVector() {
		return new Vec3D(x, y, z);
	}
	
	/**
	 * @return WorldEdit (By Sk98q) vector
	 */
	public Vector toWorldEditVector() {
		return new Vector(x, y, z);
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", x, y, z);
	}
	
	

	/**
	 * @author Radialis
	 * @param arg0 (Format: "x, y, z")
	 * @using Default separator ","
	 * @return 
	 */
	public static Vec3d fromString(String arg0) {
		return fromString(arg0, ",");
	}
	/**
	 * @author Radialis
	 * @param arg0 (Format: "x % y % z" % - example separator)
	 * @param arg1 (Separator. Default ",");
	 * @return 
	 */
	public static Vec3d fromString(String arg0, String arg1) {
		Validate.notNull(arg0);
		try {
			String[] array = arg0.replaceAll("\\s+", "").split(arg1);
			float x = Float.parseFloat(array[0]);
			float y = Float.parseFloat(array[1]);
			float z = Float.parseFloat(array[2]);
			return new Vec3d(x, y, z);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return ZERO;
	}
}
