package com.game.logisticscompanycompose.feature_contracts.domain.use_case

data class ContractUseCases(
    val addContract: AddContract,
    val deleteContract: DeleteContract,
    val deleteContractById: DeleteContractById,
    val generateContracts: GenerateContracts,
    val getContractsByCompanyId: GetContractsByCompanyId,
    val updateContract: UpdateContract
)