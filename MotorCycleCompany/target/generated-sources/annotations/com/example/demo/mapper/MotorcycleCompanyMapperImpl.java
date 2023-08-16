package com.example.demo.mapper;

import com.example.demo.dto.AssemblyLineDTO;
import com.example.demo.dto.MotorcycleCompanyDTO;
import com.example.demo.dto.ProductionLineDTO;
import com.example.demo.model.AssemblyLine;
import com.example.demo.model.MotorcycleCompany;
import com.example.demo.model.ProductionLine;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T11:54:59+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class MotorcycleCompanyMapperImpl implements MotorcycleCompanyMapper {

    @Override
    public MotorcycleCompanyDTO motorcycleCompanyToDTO(MotorcycleCompany motorcycleCompany) {
        if ( motorcycleCompany == null ) {
            return null;
        }

        MotorcycleCompanyDTO motorcycleCompanyDTO = new MotorcycleCompanyDTO();

        motorcycleCompanyDTO.setId( motorcycleCompany.getId() );
        motorcycleCompanyDTO.setName( motorcycleCompany.getName() );
        motorcycleCompanyDTO.setProductionLines( productionLineListToProductionLineDTOList( motorcycleCompany.getProductionLines() ) );
        motorcycleCompanyDTO.setAssemblyLine( mapAssemblyLineToDTO( motorcycleCompany.getAssemblyLine() ) );
        motorcycleCompanyDTO.setNumberOfMotorcycles( motorcycleCompany.getNumberOfMotorcycles() );

        return motorcycleCompanyDTO;
    }

    @Override
    public MotorcycleCompany dtoToMotorcycleCompany(MotorcycleCompanyDTO motorcycleCompanyDTO) {
        if ( motorcycleCompanyDTO == null ) {
            return null;
        }

        MotorcycleCompany motorcycleCompany = new MotorcycleCompany();

        motorcycleCompany.setId( motorcycleCompanyDTO.getId() );
        motorcycleCompany.setName( motorcycleCompanyDTO.getName() );
        motorcycleCompany.setProductionLines( productionLineDTOListToProductionLineList( motorcycleCompanyDTO.getProductionLines() ) );
        motorcycleCompany.setAssemblyLine( mapDTOToAssemblyLine( motorcycleCompanyDTO.getAssemblyLine() ) );
        motorcycleCompany.setNumberOfMotorcycles( motorcycleCompanyDTO.getNumberOfMotorcycles() );

        return motorcycleCompany;
    }

    @Override
    public ProductionLineDTO mapProductionLineToDTO(ProductionLine productionLine) {
        if ( productionLine == null ) {
            return null;
        }

        ProductionLineDTO productionLineDTO = new ProductionLineDTO();

        productionLineDTO.setTypes( productionLine.getType() );
        productionLineDTO.setId( productionLine.getId() );
        productionLineDTO.setProductionRate( productionLine.getProductionRate() );

        return productionLineDTO;
    }

    @Override
    public ProductionLine mapDTOToProductionLine(ProductionLineDTO productionLineDTO) {
        if ( productionLineDTO == null ) {
            return null;
        }

        ProductionLine productionLine = new ProductionLine();

        productionLine.setType( productionLineDTO.getTypes() );
        productionLine.setId( productionLineDTO.getId() );
        productionLine.setProductionRate( productionLineDTO.getProductionRate() );

        return productionLine;
    }

    @Override
    public AssemblyLineDTO mapAssemblyLineToDTO(AssemblyLine assemblyLine) {
        if ( assemblyLine == null ) {
            return null;
        }

        AssemblyLineDTO assemblyLineDTO = new AssemblyLineDTO();

        assemblyLineDTO.setId( assemblyLine.getId() );
        assemblyLineDTO.setType( assemblyLine.getType() );
        assemblyLineDTO.setProductionRate( assemblyLine.getProductionRate() );

        return assemblyLineDTO;
    }

    @Override
    public AssemblyLine mapDTOToAssemblyLine(AssemblyLineDTO AssemblyLineDTO) {
        if ( AssemblyLineDTO == null ) {
            return null;
        }

        AssemblyLine assemblyLine = new AssemblyLine();

        assemblyLine.setId( AssemblyLineDTO.getId() );
        assemblyLine.setType( AssemblyLineDTO.getType() );
        assemblyLine.setProductionRate( AssemblyLineDTO.getProductionRate() );

        return assemblyLine;
    }

    protected List<ProductionLineDTO> productionLineListToProductionLineDTOList(List<ProductionLine> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductionLineDTO> list1 = new ArrayList<ProductionLineDTO>( list.size() );
        for ( ProductionLine productionLine : list ) {
            list1.add( mapProductionLineToDTO( productionLine ) );
        }

        return list1;
    }

    protected List<ProductionLine> productionLineDTOListToProductionLineList(List<ProductionLineDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductionLine> list1 = new ArrayList<ProductionLine>( list.size() );
        for ( ProductionLineDTO productionLineDTO : list ) {
            list1.add( mapDTOToProductionLine( productionLineDTO ) );
        }

        return list1;
    }
}
