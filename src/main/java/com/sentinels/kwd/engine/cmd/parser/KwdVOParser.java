/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sentinels.kwd.engine.cmd.parser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.sentinels.kwd.engine.cmd.context.SessionContext;
import com.sentinels.kwd.engine.cmd.vo.KwdVO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.util.Arrays;

/**
 *
 * @author jeronimoqueiroz
 */
public class KwdVOParser {

	private static final int COLUNA_CONTROLE = 1;
	private static final int COLUNA_ACAO = 2;
	private static final int COLUNA_NOME_CAMPO = 3;
	private static final int COLUNA_VALORES = 4;

	public static List<KwdVO> buildKwdVOParserItem(File file) {
		List<KwdVO> lista = new LinkedList<>();
		Workbook w;
		try {
			w = Workbook.getWorkbook(file);
			Sheet sheet = w.getSheet(0);

			Cell cellTestSuiteName1 = sheet.getCell(0, 0);
			Cell cellTestSuiteName2 = sheet.getCell(1, 0);
			Cell cellTestSuiteName3 = sheet.getCell(2, 0);

			for (int i = 2; i < sheet.getRows(); i++) {
				Cell controle = sheet.getCell(COLUNA_CONTROLE, i);
				Cell acao = sheet.getCell(COLUNA_ACAO, i);
				Cell nomeCampo = sheet.getCell(COLUNA_NOME_CAMPO, i);
				Cell valores = sheet.getCell(COLUNA_VALORES, i);
				if (acao.getContents() != null && !acao.getContents().equals("")) {
					KwdVO vo = new KwdVO();
					vo.setTestSuiteName(cellTestSuiteName1.getContents() + " " + cellTestSuiteName2.getContents() + " "
							+ cellTestSuiteName3.getContents());
					vo.setAcao(acao.getContents());
					vo.setControle(controle.getContents());
					vo.setNomeCampo(evaluete(nomeCampo.getContents()));

					vo.setValor(evaluete(valores.getContents()));
					lista.add(vo);
				}
			}

		} catch (Exception e) {
		}
		return lista;
	}

	private static String evaluete(String value) {
		if (SessionContext.getInstance().exists(value)) {
			return SessionContext.getInstance().get(value);
		} else {
			return value;
		}
	}

	public static List<List<KwdVO>> buildKwdParser(File folder) {

		List<List<KwdVO>> lista = new LinkedList<>();

		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				List<KwdVO> itemList = buildKwdVOParserItem(listOfFile);
				lista.add(itemList);
			}
		}

		return lista;

	}

}
