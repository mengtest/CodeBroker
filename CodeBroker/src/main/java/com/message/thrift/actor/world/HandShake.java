/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.message.thrift.actor.world;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-09-04")
public class HandShake implements org.apache.thrift.TBase<HandShake, HandShake._Fields>, java.io.Serializable, Cloneable, Comparable<HandShake> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HandShake");

  private static final org.apache.thrift.protocol.TField SERVER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("serverId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SERVER_UID_FIELD_DESC = new org.apache.thrift.protocol.TField("serverUid", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new HandShakeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new HandShakeTupleSchemeFactory();

  public int serverId; // required
  public long serverUid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SERVER_ID((short)1, "serverId"),
    SERVER_UID((short)2, "serverUid");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SERVER_ID
          return SERVER_ID;
        case 2: // SERVER_UID
          return SERVER_UID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SERVERID_ISSET_ID = 0;
  private static final int __SERVERUID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SERVER_ID, new org.apache.thrift.meta_data.FieldMetaData("serverId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SERVER_UID, new org.apache.thrift.meta_data.FieldMetaData("serverUid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HandShake.class, metaDataMap);
  }

  public HandShake() {
  }

  public HandShake(
    int serverId,
    long serverUid)
  {
    this();
    this.serverId = serverId;
    setServerIdIsSet(true);
    this.serverUid = serverUid;
    setServerUidIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HandShake(HandShake other) {
    __isset_bitfield = other.__isset_bitfield;
    this.serverId = other.serverId;
    this.serverUid = other.serverUid;
  }

  public HandShake deepCopy() {
    return new HandShake(this);
  }

  @Override
  public void clear() {
    setServerIdIsSet(false);
    this.serverId = 0;
    setServerUidIsSet(false);
    this.serverUid = 0;
  }

  public int getServerId() {
    return this.serverId;
  }

  public HandShake setServerId(int serverId) {
    this.serverId = serverId;
    setServerIdIsSet(true);
    return this;
  }

  public void unsetServerId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SERVERID_ISSET_ID);
  }

  /** Returns true if field serverId is set (has been assigned a value) and false otherwise */
  public boolean isSetServerId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SERVERID_ISSET_ID);
  }

  public void setServerIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SERVERID_ISSET_ID, value);
  }

  public long getServerUid() {
    return this.serverUid;
  }

  public HandShake setServerUid(long serverUid) {
    this.serverUid = serverUid;
    setServerUidIsSet(true);
    return this;
  }

  public void unsetServerUid() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SERVERUID_ISSET_ID);
  }

  /** Returns true if field serverUid is set (has been assigned a value) and false otherwise */
  public boolean isSetServerUid() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SERVERUID_ISSET_ID);
  }

  public void setServerUidIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SERVERUID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SERVER_ID:
      if (value == null) {
        unsetServerId();
      } else {
        setServerId((java.lang.Integer)value);
      }
      break;

    case SERVER_UID:
      if (value == null) {
        unsetServerUid();
      } else {
        setServerUid((java.lang.Long)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SERVER_ID:
      return getServerId();

    case SERVER_UID:
      return getServerUid();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SERVER_ID:
      return isSetServerId();
    case SERVER_UID:
      return isSetServerUid();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof HandShake)
      return this.equals((HandShake)that);
    return false;
  }

  public boolean equals(HandShake that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_serverId = true;
    boolean that_present_serverId = true;
    if (this_present_serverId || that_present_serverId) {
      if (!(this_present_serverId && that_present_serverId))
        return false;
      if (this.serverId != that.serverId)
        return false;
    }

    boolean this_present_serverUid = true;
    boolean that_present_serverUid = true;
    if (this_present_serverUid || that_present_serverUid) {
      if (!(this_present_serverUid && that_present_serverUid))
        return false;
      if (this.serverUid != that.serverUid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + serverId;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(serverUid);

    return hashCode;
  }

  @Override
  public int compareTo(HandShake other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetServerId()).compareTo(other.isSetServerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serverId, other.serverId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetServerUid()).compareTo(other.isSetServerUid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServerUid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serverUid, other.serverUid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("HandShake(");
    boolean first = true;

    sb.append("serverId:");
    sb.append(this.serverId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("serverUid:");
    sb.append(this.serverUid);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HandShakeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public HandShakeStandardScheme getScheme() {
      return new HandShakeStandardScheme();
    }
  }

  private static class HandShakeStandardScheme extends org.apache.thrift.scheme.StandardScheme<HandShake> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HandShake struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SERVER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.serverId = iprot.readI32();
              struct.setServerIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SERVER_UID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.serverUid = iprot.readI64();
              struct.setServerUidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, HandShake struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SERVER_ID_FIELD_DESC);
      oprot.writeI32(struct.serverId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SERVER_UID_FIELD_DESC);
      oprot.writeI64(struct.serverUid);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HandShakeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public HandShakeTupleScheme getScheme() {
      return new HandShakeTupleScheme();
    }
  }

  private static class HandShakeTupleScheme extends org.apache.thrift.scheme.TupleScheme<HandShake> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HandShake struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetServerId()) {
        optionals.set(0);
      }
      if (struct.isSetServerUid()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetServerId()) {
        oprot.writeI32(struct.serverId);
      }
      if (struct.isSetServerUid()) {
        oprot.writeI64(struct.serverUid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HandShake struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.serverId = iprot.readI32();
        struct.setServerIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.serverUid = iprot.readI64();
        struct.setServerUidIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

