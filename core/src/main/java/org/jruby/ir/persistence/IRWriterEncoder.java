package org.jruby.ir.persistence;

import org.jruby.ir.IRScope;
import org.jruby.ir.instructions.Instr;
import org.jruby.ir.operands.Operand;

/**
 * Names are tough to find.  Encodes values destined to be written to a persisted space.
 * This interface doubles for the encoder which actually writes the finished encoded file
 * and also for the recorder which calculates the constant pool and basic statistics used as
 * input the the encoder which writes the file.
 */
public interface IRWriterEncoder {

    public void encode(String value);
    public void encode(String[] values);
    public void encode(Instr value);
    public void encode(IRPersistableEnum value);
    public void encode(Operand value);
    public void encode(boolean value);
    public void encode(int value);
    public void encode(long value);

    // Demarcate sections in encoded file methods

    // Start writing an individual scope header
    public void startEncodingScopeHeader(IRScope scope);
    // Finish writing an individual scope header
    public void endEncodingScopeHeader(IRScope scope);
    // Start writing an instruction list of a single scopes instructions
    public void startEncodingScopeInstrs(IRScope scope);
    // Finish writing an instruction list of a single scopes instructions
    public void endEncodingScopeInstrs(IRScope scope);
    // Start writing metadata for all scopes
    public void startEncodingScopeHeaders(IRScope script);
    // Finish writing metadata for all scopes
    public void endEncodingScopeHeaders(IRScope script);
    // Start writing out the entire scope
    public void startEncoding(IRScope script);
    // Finish writing out the entire scope
    public void endEncoding(IRScope script);
}